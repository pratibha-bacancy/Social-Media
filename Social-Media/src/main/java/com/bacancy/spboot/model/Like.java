package com.bacancy.spboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private Post post;

	@ManyToOne
	private User user;

	public Like() {

	}

	public Like(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
