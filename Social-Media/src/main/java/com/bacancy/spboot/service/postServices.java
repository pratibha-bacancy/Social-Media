package com.bacancy.spboot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.bacancy.spboot.entity.post;
import com.bacancy.spboot.repository.postRepository;

@Configuration
public class postServices {
	@Autowired
	private postRepository PostRepository;

	public List<post> getAllPosts() {
		List<post> Post = new ArrayList<>();
		PostRepository.findAll().forEach(Post::add);
		return Post;
	}

	public post getPost(int id) {
		return PostRepository.findById(id);
	}

	public void addPost(post p) {
		PostRepository.save(p);
	}

	public void updatePost(int id, post Post) {
		PostRepository.save(Post);

	}

	public void deletePost(int id) {
		PostRepository.deleteById(id);

	}

}
