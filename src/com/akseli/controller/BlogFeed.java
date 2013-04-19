package com.akseli.controller;

import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akseli.entity.BlogPost;
import com.akseli.entity.Comment;
import com.akseli.model.BlogHandler;
import com.akseli.utils.StrUtils.NewLine;

@WebServlet("/blog")
public class BlogFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlogFeed() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BlogPost> blogPosts = 
				BlogHandler.getInstance().getBlogPosts();
		request.setAttribute("blogPosts", blogPosts);
		request.getRequestDispatcher("blogfeed.jsp")
			   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String user = escapeHtml4(request.getParameter("user"));
		String title = escapeHtml4(request.getParameter("title"));
		String body = escapeHtml4(request.getParameter("body"));
		System.out.println(body);
		
		body = NewLine.addNewLines(body);
		System.out.println(body);
		
		Date date = new Date();
		BlogPost blogPost = new BlogPost(user, date, title, body);
		BlogHandler.getInstance().addBlogPost(blogPost);
		
		String destination = request.getHeader("Referer");
		response.sendRedirect(destination);
	}
}
