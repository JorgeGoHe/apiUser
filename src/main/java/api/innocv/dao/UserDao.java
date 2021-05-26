package api.innocv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.innocv.entities.User;

public interface UserDao extends JpaRepository<User, Long>{

}
