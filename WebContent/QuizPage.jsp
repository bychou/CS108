<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="web.*" %>
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
<%
	QuizManager QzManager = (QuizManager) request.getServletContext().getAttribute("Quiz Manager");
	ResultSet rs = QzManager.getQuiz(Integer.parseInt(idName));
	String creatorName = null;
	if (rs.next()) {
		creatorName = rs.getString("creatorUsername");
	}
%>
<p>Quiz Creator: <a href="\creator.jsp"><%= creatorName %>, url of creator(pulled from database)</a></p>
<%
	String currentUser = (String) request.getSession().getAttribute("username");
	if (currentUser.equals(creatorName)) {
%>
<p><a href="viewquiz.jsp?id=<%= idName %>" >View Quiz</a></p>
<%
	}
%>
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
<input name="quizId" type="hidden" value="<%= idName %>"/>
<input name="quizMode" type="hidden" value="realtest"/>
<input type="submit" value="Start Taking Quiz" /></p>
</form>
<form action="QuizPlayServlet" method="post">
<p>
<input name="quizId" type="hidden" value="<%= idName %>"/>
<input name="quizMode" type="hidden" value="practice"/>
<input type="submit" value="Start Taking Quiz in Practice Mode" /></p>
</form>
</body>
</html>