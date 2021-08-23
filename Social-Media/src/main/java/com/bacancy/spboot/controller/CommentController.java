package com.bacancy.spboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bacancy.spboot.dto.CommentDto;
import com.bacancy.spboot.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/user/{userId}/post/{postId}/comments")
	public ResponseEntity<String> addComment(@PathVariable int userId, @PathVariable int postId, @RequestBody CommentDto commentDto) {
		String build= commentService.addComment(userId, postId, commentDto);
		return new ResponseEntity<String>(build, HttpStatus.CREATED);
	}

	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable int id) {
		commentService.deleteById(id);
	}

}
