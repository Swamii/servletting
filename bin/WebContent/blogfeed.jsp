<%@page contentType="text/html" pageEncoding="UTF-8" 
import="java.util.*, com.akseli.entity.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>
<jsp:attribute name="title">Blog</jsp:attribute>
<jsp:body>
<h1 class="header text-center">Mah Blog</h1>
	<section>
		<c:if test="${0 < blogPosts.size()}">
		<c:forEach var="blogPost" items="${blogPosts}">
		<section class="blog-post">
			<p class="title"><a href="/GuestBook/blogpost/${blogPost.getId()}">${blogPost.getTitle()}</a></p>
			<p class="who-when"><span class="name">${blogPost.getUser()}</span> - 
			<span class="date">${blogPost.getDate()}</span></p>
			<p class="body">${blogPost.getBody()}</p>
		</section>
		</c:forEach>
		<hr>
		</c:if>
		<section class="new-post">
			<form method="post" action="/GuestBook/blog" class="form-horizontal">
				<legend>New post:</legend>
				<div class="control-group">
					<label for="user" class="control-label">Name:</label>
					<div class="controls">
						<input type="text" name="user" value="${user}" required="required">
					</div>
				</div>
				<div class="control-group">
					<label for="title" class="control-label">Title:</label>
					<div class="controls">
						<input type="text" name="title" required="required">
					</div>
				</div>
				<p><textarea rows="5" id="comment" name="body" required="required"></textarea></p>
				<input type="submit" value="Post">
			</form>
		</section>
	</section>
</jsp:body>
</t:wrapper>