package com.akseli.test;

import java.util.ArrayList;

import com.akseli.entity.BlogPost;
import com.akseli.entity.dao.BlogPostDAO;

public class Test {

	public static void main(String[] args) {
		
		try {
			ArrayList<BlogPost> blogPosts = (ArrayList<BlogPost>) BlogPostDAO.getAll();
			for (BlogPost post : blogPosts) {
				System.out.println(post.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
