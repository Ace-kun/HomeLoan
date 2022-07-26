package com.barclays.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.User;
import com.barclays.homeloan.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	public User addAccount(User user) {
		
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		
		return userRepository.save(newUser);
	}



}
