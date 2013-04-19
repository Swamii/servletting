package com.akseli.model;

import java.util.ArrayList;
import java.util.TreeMap;

import com.akseli.entity.BlogPost;
import com.akseli.entity.Comment;

public class BlogHandler {

	private static BlogHandler blogHandler;
	private static ArrayList<BlogPost> blogPosts;
	private int id = 0;
	
	private BlogHandler() {}
	
	public static BlogHandler getInstance() {
		if (blogHandler == null) {
			blogHandler = new BlogHandler();
			blogPosts = new ArrayList<BlogPost>();
		}
		return blogHandler;
	}

	public ArrayList<BlogPost> getBlogPosts() {
		return blogPosts;
	}
	
	public BlogPost getBlogPost(int id) {
		BlogPost correctBlogPost = null;
		for (BlogPost blogPost : blogPosts) {
			if (id == blogPost.getId()) {
				correctBlogPost = blogPost;
			}
		}
		return correctBlogPost;
	}
	
	public void addBlogPost(BlogPost blogPost) {
		id++;
		blogPost.setId(id);
		blogPosts.add(blogPost);
	}
	
}
