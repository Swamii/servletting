package com.akseli.model;

import java.util.Comparator;

import com.akseli.entity.BlogPost;

public class BlogComparator implements Comparator<BlogPost> {

	public int compare(BlogPost o1, BlogPost o2) {
		if (o1.getId() > o2.getId()) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
