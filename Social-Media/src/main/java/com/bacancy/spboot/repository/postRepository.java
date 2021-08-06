package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

	public Post findById(int id);

	public void deleteById(int id);

}
