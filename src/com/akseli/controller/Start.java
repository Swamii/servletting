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
import com.akseli.entity.dao.BlogPostDAO;
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
		try {
			BlogPost blogPost = BlogPostDAO.getById(getId(request.getRequestURI()));
			request.setAttribute("blogPost", blogPost);
			request.setAttribute("comments", blogPost.getComments());
			request.getRequestDispatcher("/blogpost.jsp")
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String referer = request.getHeader("Referer");
		
		String action = request.getRequestURI().replaceFirst(".*\\/", "");
		
		if ("addcomment".equals(action)) {
			String name = escapeHtml3(request.getParameter("name"));
			String commentText = escapeHtml3(request.getParameter("comment"));
			commentText = NewLine.addNewLines(commentText);
			Date date = new Date();	
			
			Comment comment = new Comment(name, commentText, date);
			try {
				BlogPostDAO.addComment(comment, getId(referer));
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	
	private int getId(String path) throws Exception {
		String stringId = path.replaceAll(".*\\/", "");
		//stringId = stringId.replaceAll("#.*", "");
		System.out.println(stringId);
		return Integer.parseInt(stringId);
	}
}
