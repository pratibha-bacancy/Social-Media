package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.model.Like;

public interface LikeRepository extends CrudRepository<Like, Integer> {

	 public Object countByPostId(Integer postId);

}
