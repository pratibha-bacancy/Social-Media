package com.bacancy.spboot.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class post {
	@Id
	@GeneratedValue
	private Integer id;
	private String postname;
	private String details;
	private String tags;
	private int likes;
	private String comments;
	private Date postCreatedDate;
	private Date postUpdatedDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private user User;
	
	public void setUser(user user) {
		User = user;
	}

	public post() {
		super();
	}

	

	public post(Integer id, String postname, String details, String tags, int likes, String comments,
			Date postCreatedDate, Date postUpdatedDate) {
		super();
		this.id = id;
		this.postname = postname;
		this.details = details;
		this.tags = tags;
		this.likes = likes;
		this.comments = comments;
		this.postCreatedDate = postCreatedDate;
		this.postUpdatedDate = postUpdatedDate;
	}


	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getPostCreatedDate() {
		return postCreatedDate;
	}

	public void setPostCreatedDate(Date postCreatedDate) {
		this.postCreatedDate = postCreatedDate;
	}

	public Date getPostUpdatedDate() {
		return postUpdatedDate;
	}

	public void setPostUpdatedDate(Date postUpdatedDate) {
		this.postUpdatedDate = postUpdatedDate;
	}

}
