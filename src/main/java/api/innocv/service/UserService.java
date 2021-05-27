package api.innocv.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import api.innocv.entities.User;


public interface UserService {

	public CompletableFuture<List<User>> getAllUsers();
	
	public CompletableFuture<User> getUser(Long id);
	
	public void save(User user);
	
	public void update(Long id, String name, Date birthdate);
	
	public void deleteUser(Long id);
}
