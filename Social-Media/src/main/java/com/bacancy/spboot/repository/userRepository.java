package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.entity.user;

public interface userRepository extends CrudRepository<user, Integer>{

	public user findById(int id);

	public user findByName(String name);
}

