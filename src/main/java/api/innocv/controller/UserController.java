package api.innocv.controller;

import java.util.concurrent.CompletableFuture;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.innocv.entities.User;
import api.innocv.service.UserService;

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
	public CompletableFuture<ResponseEntity> getUser(@PathVariable (required = true) String id){
		log.info("Se procede a buscar el usuario con el id: "+id);
		return userService.getUser(Long.valueOf(id)).thenApply(ResponseEntity::ok);
	}
		
	
	@PostMapping("/users/createUser")
	public ResponseEntity saveUser(@Valid @RequestBody User user) {
		log.info("Se procede a crear un nuevo usuario en la base de datos");
		userService.saveOrUpdate(user);
		
		log.info("Usuario creado correctamente");
		
		 return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body("Usuario creado correctamente");
		
	}
	
	@PutMapping("/users/updateUser/{id}")
	public ResponseEntity editar(@Valid @RequestBody User user,
			@PathVariable (required = true) String id) {
		
		log.info("Se procede a actualizar el usuario con el id " +id);
		user.setId(Long.valueOf(id));
		userService.saveOrUpdate(user);
		
		log.info("Usuario actualizado correctamente");
		
		 return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body("Usuario actualizado correctamente");
		
	}
	
	@DeleteMapping("/users/deleteUser/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		log.info("Se procede a eliminar el usuario con el id " +id);
		
		userService.deleteUser(id);
		
		log.info("Usuario eliminado correctamente");
		
		 
	}
	
	

}
