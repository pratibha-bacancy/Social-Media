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
import com.bacancy.spboot.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/posts")
	public List<PostDto> getAllPosts() {
		return postService.getAllPosts();
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDto> getPost(@PathVariable int id) {
		return new ResponseEntity<PostDto>(postService.getPost(id),HttpStatus.OK);
	}

	@PostMapping("/posts")
	public void addPost(@RequestBody PostDto postDto) {
		postService.addPost(postDto);
	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Object> updatePost(@PathVariable int id, @RequestBody PostDto postDto) {
		postService.updatePost(id, postDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Object> deletePost(int id) {
		postService.deletePost(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
