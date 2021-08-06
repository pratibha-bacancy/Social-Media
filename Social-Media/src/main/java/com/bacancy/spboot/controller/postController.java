package com.bacancy.spboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bacancy.spboot.entity.Post;
import com.bacancy.spboot.service.PostServices;

@RestController
public class PostController {
	
	@Autowired
	private PostServices postServices;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postServices.getAllPosts();
	}

	@GetMapping("/posts/{id}")
	public Post getPost(int id) {
		return postServices.getPost(id);
	}

	@PostMapping("/posts")
	public void addPost(@RequestBody Post Post) {
		postServices.addPost(Post);
	}

	@PutMapping("/posts/{id}")
	public void updatePost(@RequestBody Post Post) {
		postServices.updatePost(Post);
	}

	@DeleteMapping("/posts/{id}")
	public void deletePost(int id) {
		postServices.deletePost(id);
	}

}
