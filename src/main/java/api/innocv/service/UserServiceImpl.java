package api.innocv.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import api.innocv.dao.UserRepository;
import api.innocv.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;
	
	@Override
	@Async("userAsyncThreadExecutor")
	public CompletableFuture<List<User>> getAllUsers() {
		List<User> users = userDao.findAll();
		return CompletableFuture.completedFuture(users);
	}

	@Override
	@Async("userAsyncThreadExecutor")
	public CompletableFuture<User> getUser(Long id) {
		User user = userDao.getById(id);
		return CompletableFuture.completedFuture(user);
	}

	//Se comprueba internamente si el User existe y si existe lo actualiza y si no lo inserta
	@Override
	@Async("userAsyncThreadExecutor")
	public void saveOrUpdate(User user) {
		userDao.save(user);
	}

	@Override
	@Async("userAsyncThreadExecutor")
	public void deleteUser(Long id) {
		userDao.deleteById(id);

		
	}
	
	

}
