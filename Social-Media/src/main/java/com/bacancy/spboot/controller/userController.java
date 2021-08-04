package com.bacancy.spboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bacancy.spboot.entity.post;
import com.bacancy.spboot.entity.user;
import com.bacancy.spboot.repository.postRepository;
import com.bacancy.spboot.repository.userRepository;
import com.bacancy.spboot.service.userService;

@RestController
public class userController {

	@Autowired
	private userService UserSevice;
	@Autowired
	private userRepository UserRepository;

	@Autowired
	private postRepository PostRepository;

	@GetMapping("/users")
	public List<user> getAllUser() {
		return UserSevice.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public user getUser(@PathVariable int id) {
		return UserSevice.getUser(id);
	}

	@PostMapping("/userAdd")
	public void addUser(@RequestBody user User) {
		UserSevice.addUser(User);
	}

	@PutMapping("/userUpdate/{id}")
	public void updateUser(@RequestBody user User, @PathVariable int id) {
		UserSevice.updateUser(id, User);
	}

	@DeleteMapping("/userDelete/{id}")
	public void deleteUser(@PathVariable int id) {
		UserSevice.deleteUser(id);
	}

	@GetMapping("/users/{id}/posts")
	public List<post> retrieveAllUsers(@PathVariable int id) {
		Optional<user> userOptional = Optional.of(UserRepository.findById(id));
		return userOptional.get().getPosts();
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody post Post) {
		Optional<user> userOptional=Optional.of(UserRepository.findById(id));
		user User = userOptional.get();
		return null;
	}
}
		
		
