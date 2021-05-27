package api.innocv.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import api.innocv.entities.User;


public interface UserService {

	public CompletableFuture<List<User>> getAllUsers();
	
	public CompletableFuture<User> getUser(Long id);
	
	public void saveOrUpdate(User user);
	
	public void deleteUser(Long id);
}
