package com.bacancy.spboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "message")
	private String comment;

	@ManyToOne(fetch = FetchType.EAGER)
	private Post post;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	public Comment() {

	}

	public Comment(Integer id, String comment) {
		this.id = id;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
