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
import com.bacancy.spboot.entity.Post;
import com.bacancy.spboot.entity.User;
import com.bacancy.spboot.exception.UserNotFoundException;
import com.bacancy.spboot.repository.PostRepository;
import com.bacancy.spboot.repository.UserRepository;
import com.bacancy.spboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService UserService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return UserService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> getOneUser(@PathVariable int id) {
		User user = UserService.getUser(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
		EntityModel<User> resource = EntityModel.of(user);
		return resource;
	}

	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		UserService.addUser(user);
	}

	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		UserService.updateUser(id, user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		UserService.deleteUser(id);
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> retrievePost(@PathVariable int id) {
		Optional<User> userOptional = Optional.of(userRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		return userOptional.get().getPosts();
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createUserPost(@PathVariable int id, @RequestBody Post Post) {
		Optional<User> userOptional = Optional.of(userRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		User user = userOptional.get();
		Post.setUser(user);
		postRepository.save(Post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/users/{id}/posts")
	public void updateUserPost(@PathVariable int id, @RequestBody Post Post) {
		Optional<User> userOptional = Optional.of(userRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		User user = userOptional.get();
		Post.setUser(user);
		postRepository.save(Post);
	}

	@DeleteMapping("/users/{id}/posts")
	public void deleteUserPost(@PathVariable int id, @RequestBody Post Post) {
		Optional<User> userOptional = Optional.of(userRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		User user = userOptional.get();
		Post.setUser(user);
		postRepository.delete(Post);
	}

}
