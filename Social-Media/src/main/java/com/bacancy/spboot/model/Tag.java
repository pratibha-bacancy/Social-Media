package com.bacancy.spboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	private Post post;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	public Tag() {

	}

	public Tag(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
