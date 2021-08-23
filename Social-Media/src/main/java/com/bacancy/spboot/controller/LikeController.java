package com.bacancy.spboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bacancy.spboot.dto.LikeDto;
import com.bacancy.spboot.service.LikeService;

@RestController
public class LikeController {

	@Autowired
	private LikeService likeService;

	@GetMapping("/post/{postId}/likes")
	public int retrieveLikes(@PathVariable int postId) {
		return likeService.getAllLikes(postId);
	}

	@PostMapping("/user/{userId}/post/{postId}/like")
	public ResponseEntity<String> addLike(@PathVariable int userId, @PathVariable int postId, @RequestBody LikeDto likeDto) {
		String build= likeService.addLike(userId, postId, likeDto);
		return new ResponseEntity<String>(build, HttpStatus.CREATED);
	}
}
