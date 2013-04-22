package com.akseli.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment {
	
	@Id
	@GeneratedValue
	@Column(name="comment_id")
	private Long commentId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="comment_text")
	private String comment;
	
	@Column(name="date_added")
	private Date date = new Date();
	
	@ManyToOne
	@JoinColumn(name="blogpost_id",
				insertable=false,
				updatable=false)
	private BlogPost blogPost;
	
	public Comment() {}
	
	public Comment(String userName, String comment, Date date) {
		setUser(userName);
		setComment(comment);
		setDate(date);
	}
	
	public String getUser() {
		return userName;
	}

	public void setUser(String userName) {
		this.userName = userName;
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

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public BlogPost getBlogPost() {
		return blogPost;
	}

	public void setBlogPost(BlogPost blogPost) {
		this.blogPost = blogPost;
	}

}
