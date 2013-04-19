package com.akseli.entity;

import java.util.Date;

public class Comment {
	
	private String name;
	private String comment;
	private Date date = new Date();
	private int blogPostId;
	
	public Comment(String name, String comment, Date date) {
		setName(name);
		setComment(comment);
		setDate(date);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBlogPostId() {
		return blogPostId;
	}

	public void setBlogPostId(int blogPostId) {
		this.blogPostId = blogPostId;
	}

}
