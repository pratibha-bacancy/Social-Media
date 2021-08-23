package com.bacancy.spboot.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.bacancy.spboot.dto.LikeDto;
import com.bacancy.spboot.exception.NotFoundException;
import com.bacancy.spboot.model.Comment;
import com.bacancy.spboot.model.Like;
import com.bacancy.spboot.model.Post;
import com.bacancy.spboot.model.User;
import com.bacancy.spboot.repository.LikeRepository;
import com.bacancy.spboot.repository.PostRepository;
import com.bacancy.spboot.repository.UserRepository;

@Service
public class LikeService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	public int getAllLikes(int postId) {
		Optional<Post> posts = Optional.of(postRepository.findById(postId));
		return posts.get().getLikes().size();
	}

	public String addLike(int userId, int postId, LikeDto likeDto) {
		Like like=modelMapper.map(likeDto, Like.class);
		boolean b=false;
		userRepository.getById(userId);
		User user=userRepository.getById(userId);
		Post post=postRepository.getById(postId);
		for(Like liked:post.getLikes()) {
			Integer getUser=liked.getUser().getId();
			if(getUser.equals(userId)) {
				like.setId(liked.getId());
				b=true;
			}
		}
		if(b==false) {
			like.setPost(post);
			like.setUser(user);
			likeRepository.save(like);
		}
		return "Post Liked";
	}

}
