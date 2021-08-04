package com.bacancy.spboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bacancy.spboot.entity.post;
import com.bacancy.spboot.service.postServices;

@RestController
public class postController {
	@Autowired
	private postServices PostServices;
	
	@GetMapping("/posts")
	public List<post> getAllPosts() {
		return PostServices.getAllPosts();
	}

	@GetMapping("/post/{id}")
	public post getPost(@PathVariable int id) {
		return PostServices.getPost(id);
	}

	@PostMapping("/postAdd")
	public void addPost(@RequestBody post Post) {
		PostServices.addPost(Post);
	}

	@PutMapping("/postUpdate/{id}")
	public void updatePost(@RequestBody post Post, @PathVariable int id) {
		PostServices.updatePost(id, Post);
	}

	@DeleteMapping("/postDelete/{id}")
	public void deletePost(@PathVariable int id) {
		PostServices.deletePost(id);
	}

}
