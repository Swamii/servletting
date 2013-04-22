package com.akseli.entity.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.akseli.entity.BlogPost;
import com.akseli.entity.Comment;
import com.akseli.hibernate.SessionManager;

public class BlogPostDAO extends GenericDAO {
	
	@SuppressWarnings("unchecked")
	public static List<BlogPost> getAll() throws Exception {
		SessionFactory sf = SessionManager.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		List<BlogPost> blogPosts = session.createQuery("from BlogPost").list();
				
		session.getTransaction().commit();
        session.close();
        
        return blogPosts;
	}
	
	public static BlogPost getById(int id) throws Exception {
		SessionFactory sf = SessionManager.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		BlogPost blogPost = (BlogPost) session.get(BlogPost.class, new Long(id));
		
		session.getTransaction().commit();
		session.close();
		
		return blogPost;
	}
	
	public static void addBlogPost(BlogPost blogPost) throws Exception {
		SessionFactory sf = SessionManager.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		blogPost.setComments(new ArrayList<Comment>());
		session.save(blogPost);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void addComment(Comment comment, int blogPostId) throws Exception {
		SessionFactory sf = SessionManager.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		BlogPost blogPost = (BlogPost) session.get(BlogPost.class, new Long(blogPostId));
		blogPost.getComments().add(comment);
		session.saveOrUpdate(blogPost);
		
		session.getTransaction().commit();
		session.close();
	}
	
}
