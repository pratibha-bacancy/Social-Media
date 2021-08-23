package com.bacancy.spboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bacancy.spboot.dto.PostDto;
import com.bacancy.spboot.dto.UserDto;
import com.bacancy.spboot.model.Post;
import com.bacancy.spboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable int id) {
		return new ResponseEntity<UserDto>(userService.getUser(id), HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		UserDto user = userService.addUser(userDto);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto, @PathVariable int id) {
		userService.updateUser(id, userDto);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/user/{userId}/posts")
	public List<Post> getPostsByUser(@PathVariable int userId) {
		return userService.getPostByUser(userId);
	}

	@PostMapping("/user/{id}/posts")
	public ResponseEntity<Object> createUserPost(@PathVariable int id, @RequestBody PostDto postDto) {
		return new ResponseEntity<>(userService.createPostByUser(id, postDto), HttpStatus.CREATED);

	}

	@PutMapping("/user/{id}/posts")
	public ResponseEntity<Object> updatePostByUser(@PathVariable int id, @RequestBody PostDto postDto) {
		userService.updatePostByUser(id, postDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/user/post/{id}")
	public void deletePostByUser(@PathVariable int id) {
		userService.deletePostByUser(id);
	}

}
