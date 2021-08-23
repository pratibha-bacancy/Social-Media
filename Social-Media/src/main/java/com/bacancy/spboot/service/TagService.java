package com.bacancy.spboot.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.bacancy.spboot.dto.TagDto;
import com.bacancy.spboot.exception.NotFoundException;
import com.bacancy.spboot.model.Post;
import com.bacancy.spboot.model.Tag;
import com.bacancy.spboot.model.User;
import com.bacancy.spboot.repository.PostRepository;
import com.bacancy.spboot.repository.TagRepository;
import com.bacancy.spboot.repository.UserRepository;

@Service
public class TagService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TagRepository tagRepository;

	public String addTag(int userId, int postId, @RequestBody TagDto tagDto) {
		Tag tag = modelMapper.map(tagDto, Tag.class);
		Optional<User> user = Optional.of(userRepository.findById(userId));
		Optional<Post> post = Optional.of(postRepository.findById(postId));
		if (!post.isPresent()) {
			throw new NotFoundException("Post does not exist");
		}
		User userDto = user.get();
		Post postDto = post.get();
		tag.setPost(postDto);
		tag.setUser(userDto);
		tag = tagRepository.save(tag);
		return "Tag Saved";
	}

	public void deleteById(int id) {
		tagRepository.deleteById(id);
	}

}
