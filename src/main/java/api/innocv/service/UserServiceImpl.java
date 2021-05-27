package api.innocv.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import api.innocv.dao.UserDao;
import api.innocv.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Async("userAsyncThreadExecutor")
	public CompletableFuture<List<User>> getAllUsers() {
		List<User> users = userDao.findAll();
		return CompletableFuture.completedFuture(users);
	}

	@Override
	@Async("userAsyncThreadExecutor")
	public CompletableFuture<User> getUser(Long id) {
		User user = userDao.findById(id);
		return CompletableFuture.completedFuture(user);
	}

	@Override
	@Async("userAsyncThreadExecutor")
	public void save(User user) {
		userDao.save(user);
	}
	
	@Override
	@Async("userAsyncThreadExecutor")
	public void update(Long id, String name, Date birthdate) {
		userDao.update(id, name, birthdate);
	}

	@Override
	@Async("userAsyncThreadExecutor")
	public void deleteUser(Long id) {
		userDao.deleteById(id);

		
	}
	

	

}
