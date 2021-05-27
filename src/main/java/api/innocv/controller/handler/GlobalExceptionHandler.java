package api.innocv.controller.handler;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleHttpMessageNotReadableException (HttpMessageNotReadableException ex){
		
		return new ResponseEntity<Object>("Uno de los datos introducidos no responde con el tipo de dato solicitado,"
				+ "compruebe que el tipo de dato solicitado corresponde con el formato (numerico, fecha....)", HttpStatus.UNPROCESSABLE_ENTITY);
			
		}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleHttpMessageNotReadableException (EntityNotFoundException ex){
		
		return new ResponseEntity<Object>("No existe ningún registro con los datos solicitados", HttpStatus.ACCEPTED);
			
		}
	
	
}
