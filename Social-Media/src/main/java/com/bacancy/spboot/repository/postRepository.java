package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.entity.post;


public interface postRepository extends CrudRepository<post, Integer>{
	public post findById(int id);
	
}
