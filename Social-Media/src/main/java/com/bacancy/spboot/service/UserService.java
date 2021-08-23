package com.bacancy.spboot.service;

import java.net.URI;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.bacancy.spboot.model.Post;
import com.bacancy.spboot.model.User;
import com.bacancy.spboot.dto.PostDto;
import com.bacancy.spboot.dto.UserDto;
import com.bacancy.spboot.exception.DataFoundException;
import com.bacancy.spboot.exception.NotFoundException;
import com.bacancy.spboot.repository.PostRepository;
import com.bacancy.spboot.repository.UserRepository;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<UserDto> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return userDtos;
	}

	public UserDto getUser(int id) {
		User user = userRepository.findById(id);
		if (!userRepository.existsById(id)) {
			throw new NotFoundException("User does not exist");
		}
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	public UserDto addUser(UserDto userDto) {
		Optional<User> user = Optional.of(userRepository.findByEmail(userDto.getEmail()));
		if (user.isPresent())
			throw new DataFoundException("User Already Exist!");
		User model = modelMapper.map(userDto, User.class);
		userRepository.save(model);
		return userDto;
	}

	public UserDto updateUser(int id, UserDto userDto) {
		Optional<User> user = userRepository.findById(userDto.getId());
		if (!user.isPresent())
			throw new NotFoundException("User Not Found!");
		User model = modelMapper.map(userDto, User.class);
		userRepository.save(model);
		return userDto;
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public List<Post> getPostByUser(int userId) {
		Optional<User> user = Optional.of(userRepository.findById(userId));
		if (!user.isPresent()) {
			throw new NotFoundException("User Not Found!!");
		}
		return user.get().getPosts();
	}

	public ResponseEntity<Object> createPostByUser(int id, PostDto postDto) {
		Post post = modelMapper.map(postDto, Post.class);
		Optional<User> userOptional = Optional.of(userRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new NotFoundException("id: " + id);
		}
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	public void updatePostByUser(int id, PostDto postDto) {
		Post post = modelMapper.map(postDto, Post.class);
		Optional<User> userOptional = Optional.of(userRepository.findById(id));
		if (!userOptional.isPresent()) {
			throw new NotFoundException("id: " + id);
		}
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
	}

	public void deletePostByUser(int id) {
		postRepository.deleteById(id);
	}

}
