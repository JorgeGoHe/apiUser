package api.innocv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.innocv.entities.User;
import api.innocv.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
		
	}

}
