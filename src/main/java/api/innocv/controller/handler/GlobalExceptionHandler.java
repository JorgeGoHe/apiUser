package api.innocv.controller.handler;

import java.util.concurrent.ExecutionException;

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
	public ResponseEntity<Object> handleEntityNotFoundException (EntityNotFoundException ex){
		
		return new ResponseEntity<Object>("No existe ningún registro con los datos solicitados", HttpStatus.NOT_FOUND);
			
		}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> handleNumberFormatException (NumberFormatException ex){
		
		return new ResponseEntity<Object>("Uno de los datos numericos es incorrecto", HttpStatus.UNPROCESSABLE_ENTITY);
			
		}
	
	@ExceptionHandler(InterruptedException.class)
	public ResponseEntity<Object> handleInterruptedException (InterruptedException ex) {
	    Thread.currentThread().interrupt();
		return new ResponseEntity<Object>("No se ha podido completar la accion, intentelo mas tarde", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	
	@ExceptionHandler(ExecutionException.class)
	public ResponseEntity<Object> handleExecutionException (ExecutionException ex) {
	    Thread.currentThread().interrupt();
		return new ResponseEntity<Object>("No se ha podido completar la accion, intentelo mas tarde", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	
	
	
}
