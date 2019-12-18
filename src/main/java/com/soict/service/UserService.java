package com.soict.service;

import java.util.List;

import org.hibernate.sql.Delete;

import com.soict.entities.User;

public interface UserService {
	boolean save(User user);
	
	boolean delete(User user);
	
	User findByUsername(String username);
	
	List<User> findByActive(int active);


}
