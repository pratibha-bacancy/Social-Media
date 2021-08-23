package com.bacancy.spboot.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.bacancy.spboot.dto.CommentDto;
import com.bacancy.spboot.exception.NotFoundException;
import com.bacancy.spboot.model.Comment;
import com.bacancy.spboot.model.Post;
import com.bacancy.spboot.model.User;
import com.bacancy.spboot.repository.CommentRepository;
import com.bacancy.spboot.repository.PostRepository;
import com.bacancy.spboot.repository.UserRepository;

@Service
public class CommentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	public String addComment(int userId, int postId, @RequestBody CommentDto commentDto) {
		Comment comment = modelMapper.map(commentDto, Comment.class);
		Optional<User> user = Optional.of(userRepository.findById(userId));
		Optional<Post> post = Optional.of(postRepository.findById(postId));
		if (!post.isPresent()) {
			throw new NotFoundException("Post does not exist");
		}
		User userDto = user.get();
		Post postDto = post.get();
		comment.setPost(postDto);
		comment.setUser(userDto);
		comment = commentRepository.save(comment);
		return "Comment Saved";
	}

	public void deleteById(int id) {
		commentRepository.deleteById(id);
	}

}
