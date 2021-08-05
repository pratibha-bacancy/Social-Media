package com.bacancy.spboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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
import com.bacancy.spboot.exception.UserNotFoundException;
import com.bacancy.spboot.repository.postRepository;
import com.bacancy.spboot.repository.userRepository;
import com.bacancy.spboot.service.userService;

@RestController
public class userController {

	@Autowired
	private userService UserService;
	@Autowired
	private userRepository UserRepository;
	@Autowired
	private postRepository PostRepository;

	@GetMapping("/users")
	public List<user> getAllUser() {
		return UserService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public EntityModel<user> getUser(@PathVariable int id) {
		user User = UserService.getUser(id);
		if (User == null)
			throw new UserNotFoundException("id-" + id);

		EntityModel<user> resource = EntityModel.of(User);

		return resource;
	}

	@PostMapping("/user")
	public void addUser(@RequestBody user User) {
		UserService.addUser(User);
	}

	@PutMapping("/user/{id}")
	public void updateUser(@RequestBody user User, @PathVariable int id) {
		UserService.updateUser(id, User);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		UserService.deleteUser(id);
	}

	@GetMapping("/users/{id}/posts")
	public List<post> retrievePost(@PathVariable int id) {
		Optional<user> userOptional = Optional.of(UserRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		return userOptional.get().getPosts();
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createUserPost(@PathVariable int id, @RequestBody post Post) {
		Optional<user> userOptional = Optional.of(UserRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		user User = userOptional.get();
		Post.setUser(User);
		PostRepository.save(Post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/users/{id}/posts/{id}")
	public void updateUserPost(@RequestBody post Post, @PathVariable int id) {
		Optional<user> userOptional = Optional.of(UserRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		
	}

	
}
