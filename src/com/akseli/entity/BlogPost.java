package com.akseli.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="BLOGPOST")
public class BlogPost {
	
	@Id
	@GeneratedValue
	@Column(name="blogpost_id")
	private Long id;
	
	@Column(name="username")
	private String user;
	
	@Column(name="date_added")
	private Date date;
	
	@Column(name="title")
	private String title;
	
	@Column(name="body")
	private String body;
	
	@OneToMany(cascade={CascadeType.ALL},
			   fetch=FetchType.EAGER)
	@JoinColumn(name="blogpost_id")
	@IndexColumn(name="idx")
	private List<Comment> comments;
	
	public BlogPost() {};
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
