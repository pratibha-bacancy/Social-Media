package com.bacancy.spboot.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="post_name")
	private String postName;
	
	@Column(name="details")
	private String details;
	
	@Column(name="tags")
	private String tags;
	
	@Column(name="likes")
	private Integer likes;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="post_created_date")
	private Date postCreatedDate;
	
	@Column(name="post_updated_date")
	private Date postUpdatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Post() {

	}

	public Post(Integer id, String postName, String details, String tags, Integer likes, String comments,
			Date postCreatedDate, Date postUpdatedDate, User user) {
		this.id = id;
		this.postName = postName;
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

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
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

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
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

	public void setUser(User user) {
		this.user = user;
	}
	
}
