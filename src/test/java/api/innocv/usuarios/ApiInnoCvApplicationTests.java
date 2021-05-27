package api.innocv.usuarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import api.innocv.entities.User;

@SpringBootTest
class ApiInnoCvApplicationTests {

	@Test
	public void getAllUsers()
	  throws ClientProtocolException, IOException {
	 
	   
	    HttpUriRequest request = new HttpGet( "http://localhost:8443/api/users/getAllUsers");

	    
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

	    
	    assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	public void getUserExist()
	  throws ClientProtocolException, IOException {
	
	    HttpUriRequest request = new HttpGet( "http://localhost:8443/api/users/getUser/"+1);

	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

	    
	    assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	public void getUserNoExist()
	  throws ClientProtocolException, IOException {
	    HttpUriRequest request = new HttpGet( "http://localhost:8443/api/users/getUser/"+9324);

	    
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

	    
	    assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
	}
	
	@Test
	public void createUserCorrect()
	  throws ClientProtocolException, IOException, URISyntaxException {
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8443/api/users/createUser";
	    URI uri = new URI(baseUrl);
	     
	    User user = new User();
	    user.setName("Prueba");
	    user.setBirthdate(new Date());
	 
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, user, String.class);
	    result.getStatusCodeValue();
	    //Verify request succeed
	    
	    assertEquals(result.getStatusCodeValue(), HttpStatus.SC_CREATED);
	}
	
	
	
	@Test
	public void deleteUserCompleteData()
	  throws ClientProtocolException, IOException {
	    HttpUriRequest request = new HttpDelete( "http://localhost:8443/api/users/deleteUser/"+1);

	    
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

	    
	    assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NO_CONTENT);
	}

}
