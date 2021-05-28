package api.innocv.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.innocv.entities.User;
import api.innocv.service.UserService;
import api.innocv.util.ApiUtil;

@RestController
@SuppressWarnings("rawtypes")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	

	 private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(value = "/users/getAllUsers", produces = "application/json")
	public CompletableFuture<ResponseEntity> getAllUsers() {
		log.info("Se procede a buscar todos los usuarios de la base de datos");
		
		return userService.getAllUsers().thenApply(ResponseEntity::ok);
		
	}
	
	
	
	
	@GetMapping(value = "/users/getUser/{id}", produces = "application/json")
	public ResponseEntity getUser(@PathVariable (required = true) String id){
		try {
		log.info("Se procede a buscar el usuario con el id: "+id);
		CompletableFuture<User> user = userService.getUser(Long.valueOf(id));
		if(user.get()==null) {
			 return ResponseEntity
		                .status(HttpStatus.NOT_FOUND)
		                .body("El usuario solicitado no existe");
			 	
		}
		 return ResponseEntity
	                .status(HttpStatus.OK)
	                .body(user.get());
		 
		} catch (InterruptedException | ExecutionException e) {
		    Thread.currentThread().interrupt();
			log.error("Error al obtener el Usuario");
			return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("No se ha podido completar la accion, intentelo mas tarde");
		}
		 
	}
		
	
	@PostMapping("/users/createUser")
	public ResponseEntity saveUser(@Valid @RequestBody User user) {
		try {
			log.info("Se procede a crear un nuevo usuario en la base de datos");

			// Se valida que el formato de la fecha de nacimiento se correcto
			ApiUtil.formatDate(user.getBirthdate());

			userService.save(user);

			log.info("Usuario creado correctamente");

			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
		} catch (ParseException ex) {
			log.error("Error al crear el Usuario");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"Uno de los formatos de los parámetros es incorrecto, compruebe todos los datos introducidos");
		}

	}
	
	@PostMapping("/users/updateUser/{id}")
	public ResponseEntity editar(@Valid @RequestBody User user,
			@PathVariable(required = true) String id) {
		try {
			log.info("Se procede a actualizar el usuario con el id " +id);
			
			
			if(userService.getUser(Long.valueOf(id)).get() == null) {
				 return ResponseEntity
			                .status(HttpStatus.NOT_FOUND)
			                .body("El usuario que se ha solicitado actualizar no existe");
			}
			
			// Se valida que el formato de la fecha de nacimiento se correcto
			Date birthdateFormated = ApiUtil.formatDate(user.getBirthdate());
			userService.update(Long.valueOf(id), user.getName(), birthdateFormated);
			
			log.info("Usuario actualizado correctamente");
			
			 return ResponseEntity
		                .status(HttpStatus.CREATED)
		                .body("Usuario actualizado correctamente");
		 
		} catch (InterruptedException | ExecutionException e) {
		    Thread.currentThread().interrupt();
			log.error("Error al actualizar el Usuario");
			return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("No se ha podido completar la accion, intentelo mas tarde");
		} catch (ParseException ex) {
			log.error("Error al actualizar el Usuario");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"Uno de los formatos de los parámetros es incorrecto, compruebe todos los datos introducidos");
		}
		 
		
	}
	
	@DeleteMapping("/users/deleteUser/{id}")
	public ResponseEntity eliminar(@PathVariable Long id) {
		try {
		log.info("Se procede a eliminar el usuario con el id " +id);
		
		if(userService.getUser(Long.valueOf(id)).get() == null) {
			 return ResponseEntity
		                .status(HttpStatus.NOT_FOUND)
		                .body("El usuario que se ha solicitado eliminar no existe");
		}
		
		userService.deleteUser(id);
		 
		log.info("Usuario eliminado correctamente");
		
		return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Usuario eliminado correctamente");
		
		} catch (InterruptedException | ExecutionException e) {
			log.error("Error al eliminar el Usuario");
		    Thread.currentThread().interrupt();
			return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("No se ha podido completar la accion, intentelo mas tarde");
		}
		
		 
	}
	
	

}
