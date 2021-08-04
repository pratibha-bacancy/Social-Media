package com.bacancy.spboot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.bacancy.spboot.entity.user;
import com.bacancy.spboot.repository.userRepository;

@Configuration
public class userService {
	@Autowired
	private userRepository UserRepository;

	public List<user> getAllUsers() {
		List<user> User = new ArrayList<>();
		UserRepository.findAll().forEach(User::add);
		return User;
	}

	public user getUser(int id) {
		return UserRepository.findById(id);
	}

	public void addUser(user u) {
		UserRepository.save(u);
	}

	public void updateUser(int id, user User) {
		UserRepository.save(User);

	}

	public void deleteUser(int id) {
		UserRepository.deleteById(id);

	}

}
