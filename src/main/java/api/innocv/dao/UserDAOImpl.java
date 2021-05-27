package api.innocv.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import api.innocv.entities.User;

@Repository
public class UserDAOImpl implements UserDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> findAllQuery = currentSession.createQuery("from User", User.class);

        List<User> users = findAllQuery.getResultList();

        return users;

    }

    @Override
    public User findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        User user = currentSession.get(User.class, id);

        return user;
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(user);  

    }
    
    @Override
    @Modifying
	public void update(Long id, String name, Date birthdate) {
    	 Session currentSession = entityManager.unwrap(Session.class);
    	 

         Query<User> update = currentSession.createQuery("update User u set u.name = :name, u.birthdate = :birthdate where id=:id");

         update.setParameter("id", id);
         update.setParameter("name", name);
         update.setParameter("birthdate", birthdate);
         update.executeUpdate();
		
	}

    @Override
    public void deleteById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> delete = currentSession.createQuery("delete from User where id=:id");

        delete.setParameter("id", id);
        delete.executeUpdate();

    }

	


}

