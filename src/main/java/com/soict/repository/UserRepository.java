package com.soict.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soict.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	List<User> findAll();
	//void save(User user);
	User findByUsername(String username);
	
	List<User> findByActive(int active);

}
