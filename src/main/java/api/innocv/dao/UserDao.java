package api.innocv.dao;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import api.innocv.entities.User;


public interface UserDao {
	
	public List<User> findAll();

    public User findById(Long id);

    public void save(User user);

    public void deleteById(Long id);

    @Transactional
	public void update(Long id, String name, Date birthdate);
	
}
