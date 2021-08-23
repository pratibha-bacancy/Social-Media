package com.bacancy.spboot.dto;

import java.util.Date;

public class PostDto {

	private Integer id;
	private String postName;
	private String details;
	private Date postCreatedDate;
	private Date postUpdatedDate;

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

}
