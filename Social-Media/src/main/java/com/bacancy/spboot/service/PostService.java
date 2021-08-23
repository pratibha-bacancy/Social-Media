package com.bacancy.spboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bacancy.spboot.dto.PostDto;
import com.bacancy.spboot.exception.DataFoundException;
import com.bacancy.spboot.exception.NotFoundException;
import com.bacancy.spboot.model.Post;
import com.bacancy.spboot.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<PostDto> getAllPosts() {
		List<Post> posts = (List<Post>) postRepository.findAll();
		List<PostDto> postDto = posts.stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

	public PostDto getPost(int id) {
		Post post = postRepository.findById(id);
		if (!postRepository.existsById(id)) {
			throw new NotFoundException("Post does not exist");
		}
		PostDto postDto = modelMapper.map(post, PostDto.class);
		return postDto;
	}

	public PostDto addPost(PostDto postDto) {
		Optional<Post> post = postRepository.findById(postDto.getId());
		if (post.isPresent())
			throw new NotFoundException("Post Already Exist!");
		Post model = modelMapper.map(postDto, Post.class);
		postRepository.save(model);
		return postDto;
	}

	public PostDto updatePost(int id, PostDto postDto) {
		Optional<Post> post = postRepository.findById(postDto.getId());
		if (!post.isPresent())
			throw new DataFoundException("Post Not Found!");
		Post model = modelMapper.map(postDto, Post.class);
		postRepository.save(model);
		return postDto;
	}

	public void deletePost(int id) {
		postRepository.deleteById(id);
	}

}
