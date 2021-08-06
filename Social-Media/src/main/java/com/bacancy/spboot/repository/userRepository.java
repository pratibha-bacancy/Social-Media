package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findById(int id);

	public User findByName(String name);

}
