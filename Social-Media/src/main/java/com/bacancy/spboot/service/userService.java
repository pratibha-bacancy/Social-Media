package com.bacancy.spboot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.bacancy.spboot.entity.User;
import com.bacancy.spboot.repository.UserRepository;

@Configuration
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> User = new ArrayList<>();
		userRepository.findAll().forEach(User::add);
		return User;
	}

	public User getUser(int id) {
		return userRepository.findById(id);
	}

	public void addUser(User u) {
		userRepository.save(u);
	}

	public void updateUser(int id, User user) {
		userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
