package com.bacancy.spboot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.bacancy.spboot.entity.Post;
import com.bacancy.spboot.repository.PostRepository;

@Configuration
public class PostServices {

	@Autowired
	private PostRepository postRepository;

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}

	public Post getPost(int id) {
		return postRepository.findById(id);
	}

	public void addPost(Post p) {
		postRepository.save(p);
	}

	public void updatePost(Post Post) {
		postRepository.save(Post);
	}

	public void deletePost(int id) {
		postRepository.deleteById(id);
	}

}
