package com.bacancy.spboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bacancy.spboot.dto.TagDto;
import com.bacancy.spboot.service.TagService;

@RestController
public class TagController {

	@Autowired
	private TagService tagService;

	@PostMapping("/user/{userId}/post/{postId}/tags")
	public String addtag(@PathVariable int userId, @PathVariable int postId, @RequestBody TagDto tagDto) {
		return tagService.addTag(userId, postId, tagDto);
	}
	
	@DeleteMapping("/tags/{id}")
	public void deleteTag(@PathVariable int id) {
		tagService.deleteById(id);
	}
}
