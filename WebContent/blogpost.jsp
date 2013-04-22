<%@page contentType="text/html" pageEncoding="UTF-8" 
import="java.util.*, com.akseli.entity.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
	<jsp:attribute name="title">${blogPost.getTitle()}</jsp:attribute>
	<jsp:body>
	<section class="blog-post">
		<p class="title">${blogPost.getTitle()}</p>
		<p class="who-when">By <span class="name">${blogPost.getUser()}</span> - 
		<span class="date">${blogPost.getDate()}</span></p>
		<p class="body">${blogPost.getBody()}</p>
	</section>
	
	<section id="comment-area">
	<c:if test="${0 < comments.size()}">
		<div class="comment-header">
			<h3>Comments</h3>
		</div>
		<div class="comments">
			<ul id="comments-list" class="unstyled">
			<c:forEach items="${comments}" var="comment">			
				<li>
				<p><span class="name">${comment.getUser()}</span><span class="date"> posted on ${comment.getDate().toString()}</span>:</p>
				<p class="comment">${comment.getComment()}</p>
				</li>
			</c:forEach>
			</ul>
		</div>
	</c:if>
	</section>
	<section class="new-post">
		<form action="/GuestBook/addcomment" method="post">
			<fieldset>
				<legend>Leave a comment</legend>
				<label for="name">Name</label>
				<p><input type="text" id="name" name="name" value="${user}"></p>
				<label for="comment">Comment:</label>
				<p><textarea rows="3" id="comment" name="comment"></textarea></p>
				<input type="submit">
			</fieldset>
		</form>
	</section>
	</jsp:body>
</t:wrapper>