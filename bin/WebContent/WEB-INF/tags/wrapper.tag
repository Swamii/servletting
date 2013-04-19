<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%
	String user = (String) session.getAttribute("user");
	boolean loggedIn = false;
	if (null != user) {
		loggedIn = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<title><jsp:invoke fragment="title"/></title>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet"
	media="screen" type="text/css">
<link href="<%= request.getContextPath() %>/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="/GuestBook">De Guest Book</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="/GuestBook/blog">Blog</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<section class="container content">
		<div class="wrapper">
			<div class="proper-content">
				<section class="row">
					<section class="span8">
						<jsp:doBody />
					</section>
					<section class="span4">
						<% if (!loggedIn) { %>
						<form method="post" action="<%= request.getContextPath() %>/login">
							<fieldset>
								<legend>Login Form</legend>
								<p><input type="text" name="username" placeholder="Username..."
										required="required"></p>
								<p><input type="password" name="password"
										placeholder="Password..." required="required"></p>
								<input type="submit" value="Login">
							</fieldset>
						</form>
						<% } else { %>
						<p>
							Welcome
							<%= user %>
						</p>
						<form method="post"
							action="<%=request.getContextPath()%>/logout">
							<input type="submit" value="Logout">
						</form>
					</section>
						<% } %>
				</section>
			</div>
			<div class="push"></div>
		</div>

		<div class="footer-wrapper text-center">
			<footer>
				<p class="muted credit">Site made by Akseli Nelander.</p>
			</footer>
		</div>
	</section>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>