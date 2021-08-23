package com.bacancy.spboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bacancy.spboot.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

	public List<Comment> findAllById(int id);

}
