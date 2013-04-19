package com.akseli.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml3;

import com.akseli.entity.BlogPost;
import com.akseli.entity.Comment;
import com.akseli.model.BlogHandler;
import com.akseli.utils.StrUtils.NewLine;

/**
 * Servlet implementation class Start
 */
@WebServlet(value={"/blogpost/*", "/login", "/logout", "/addcomment"})
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Start() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlogPost blogPost = getBlogPost(request.getRequestURI());
		if (blogPost != null) {
			ArrayList<Comment> comments = (ArrayList<Comment>) blogPost.getComments();
			request.setAttribute("blogPost", blogPost);
			request.setAttribute("comments", comments);
			request.getRequestDispatcher("/blogpost.jsp")
				   .forward(request, response);
		}
		else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String referer = request.getHeader("Referer");
		System.out.println(referer);
		
		String action = request.getRequestURI().replaceFirst(".*\\/", "");
		
		if ("addcomment".equals(action)) {
			String name = escapeHtml3(request.getParameter("name"));
			String commentText = escapeHtml3(request.getParameter("comment"));
			Date date = new Date();	
			
			commentText = NewLine.addNewLines(commentText);
			
			Comment comment = new Comment(name, commentText, date);
			BlogPost blogPost = getBlogPost(referer);
			blogPost.addComment(comment);
		} else if ("login".equals(action)) {
			HttpSession session = request.getSession();
			
			String username = escapeHtml3(request.getParameter("username"));
			
			session.setAttribute("user", username);
		} else if ("logout".equals(action)) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
		}
		
		response.sendRedirect(referer);
	}
	
	private BlogPost getBlogPost(String path) {
		String stringId = path.replaceAll(".*\\/", "");
		BlogPost blogPost = null;
		if (stringId != null) {
			try {
				int id = Integer.parseInt(stringId);
				blogPost = BlogHandler.getInstance().getBlogPost(id);
			} catch (NumberFormatException e) {}
		}
		
		return blogPost;
	}
}
