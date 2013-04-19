package com.akseli.entity;

import java.util.ArrayList;
import java.util.Date;

public class BlogPost {
	
	private int id;
	private String user;
	private Date date;
	private String title;
	private String body;
	private ArrayList<Comment> comments = new ArrayList<Comment>();
		
	public BlogPost(String user, Date date, String title, String body) {
		setUser(user);
		setDate(date);
		setTitle(title);
		setBody(body);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
}
