package com.soict.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soict.entities.User;
import com.soict.repository.UserRepository;
import com.soict.service.UserService;

@Service
public class UserService_impl implements UserService {
    @Autowired
	private UserRepository userRepository;
    

	@Override
	public boolean save(User user) {
		try {
			this.userRepository.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			showError("save", e);
		}
		return false;
	}

	@Override
	public boolean delete(User user) {
		try {
			this.userRepository.delete(user);
			return true;
		} catch (Exception e) {
			showError("delete", e);
		}
		return false;
	}

	@Override
	public User findByUsername(String username) {
		try {
			return this.userRepository.findByUsername(username);
		} catch (Exception e) {
			// TODO: handle exception
			showError("findByUsername() ", e);
		}
		return null;
	}

	@Override
	public List<User> findByActive(int active) {
		try {
			return this.userRepository.findByActive(active);
		} catch (Exception e) {
			// TODO: handle exception
			showError("findByActive() ", e);
		}
		return null;
	}
	
	public void showError(String s1, Exception e) {
		System.out.println("Error "+s1+" in UserService_impl: "+e.getMessage());
	}

}
