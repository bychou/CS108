<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Summary Page</title>
</head>
<body>
<h1>Quiz Description (Quiz number, Quiz subject, Other description)</h1>
<%
	String idName = request.getParameter("id");
%>
<p>Quiz id = <%= idName %></p>
<p>Quiz Creator: <a href="\creator.jsp">url of creator(pulled from database)</a></p>
<p>List of user's past performance</p>
<ul>
<li>performance1</li>
<li>performance2</li>
<li>performance3</li>
</ul>
<p>List of highest performers</p>
<ul>
<li>performer1</li>
<li>performer2</li>
<li>performer3</li>
</ul>
<p>print summary statistics</p>
<form action="QuizPlayServlet" method="post">
<p>
<input name="quizType" type="hidden" value="realtest"/>
<input type="submit" value="Start Quiz" /></p>
</form>
<form action="QuizPlayServlet" method="post">
<p>
<input name="quizType" type="hidden" value="practice"/>
<input type="submit" value="Start Practice Quiz" /></p>
</form>
</body>
</html>