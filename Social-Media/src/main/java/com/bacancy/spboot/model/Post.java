package com.bacancy.spboot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "post_name")
	private String postName;

	@Column(name = "details")
	private String details;

	@Column(name = "post_created_date")
	private Date postCreatedDate;

	@Column(name = "post_updated_date")
	private Date postUpdatedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private List<Tag> tags = new ArrayList<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<Like> likes = new ArrayList<>();

	public Post() {

	}

	public Post(Integer id, String postName, String details, Date postCreatedDate, Date postUpdatedDate, User user,
			List<Tag> tags, List<Comment> comments, List<Like> likes) {
		this.id = id;
		this.postName = postName;
		this.details = details;
		this.postCreatedDate = postCreatedDate;
		this.postUpdatedDate = postUpdatedDate;
		this.user = user;
		this.tags = tags;
		this.comments = comments;
		this.likes = likes;
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

	public List<Comment> getComments() {
		return comments;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public List<Like> getLikes() {
		return likes;
	}

}
