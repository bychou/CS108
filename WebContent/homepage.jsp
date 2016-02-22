<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
	/* Store username to session. */
	request.getSession().setAttribute("username", request.getParameter("username"));
%>
<title>Welcome <%= request.getSession().getAttribute("username") %></title>
</head>
<body>
<h1>Welcome <%= request.getSession().getAttribute("username") %></h1>
<p><a href="message.jsp">Message</a></p>
<p><a href="friendRequest.jsp">Friend Request</a></p>
<p><a href="CreateQuiz.jsp">Create New Quiz</a></p>
<p><a href="QuizPage.jsp">Quiz Page</a></p>
<p><a href="searchUsers.jsp">Find Players</a></p>
</body>
</html>
