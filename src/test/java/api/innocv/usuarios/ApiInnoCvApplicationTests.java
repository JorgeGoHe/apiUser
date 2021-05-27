package api.innocv.usuarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
