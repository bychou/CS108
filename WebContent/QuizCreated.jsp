<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Created</title>
</head>
<body>
<h1>Quiz Number <%= (Integer) session.getAttribute("quizNumber") %> succesfully created
by <%= request.getSession().getAttribute("username") %>
</h1>
<p><a href="viewquiz.jsp?id=<%= (Integer) session.getAttribute("quizNumber") %>" >View Created Quiz</a></p>
</body>
</html>
