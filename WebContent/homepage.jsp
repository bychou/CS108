<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.*" %>
<%@ page import="java.sql.*" %>
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
<p><u>List of all quizzes:</u></p>
<ul>
<%
	QuizManager QzManager = (QuizManager) request.getServletContext().getAttribute("Quiz Manager");
	ResultSet quizrs = QzManager.getQuizList();
	while (quizrs.next()) {
%>
<li><a href="QuizPage.jsp?id=<%= quizrs.getString("quizId") %>"><%= quizrs.getString("title") %></a></li>
<%
	}
%>
</ul>
<p><u>List of quizzes created by you:</u></p>
<ul>
<%
	ResultSet quizUserRs = QzManager.getQuizListbyUser((String) request.getSession().getAttribute("username"));
	if (quizUserRs.next()) {
%>
<li><a href="QuizPage.jsp?id=<%= quizUserRs.getString("quizId") %>"><%= quizUserRs.getString("title") %></a></li>
<%		
	} else {
%>
<li><p>No quizzes created by you</p></li>
<%	
	}
	while (quizUserRs.next()) {
%>
<li><a href="QuizPage.jsp?id=<%= quizUserRs.getString("quizId") %>"><%= quizUserRs.getString("title") %></a></li>
<%
	}
%>
</ul>
<p><a href="searchUsers.jsp">Find Players</a></p>
<p><a href="history.jsp">History</a></p>
<p><a href="administratorTools.jsp"> Administrator Tools</a></p>

<h3>Announcements</h3>
<%
	UserDataManager userDataManager = (UserDataManager) request.getServletContext().getAttribute("User Data Manager");
	ResultSet rs = userDataManager.getAnnouncements();
	
	if (!rs.isBeforeFirst()) {
		out.println("<p> There is no announcement </p>");
	} else {
		while (rs.next()) {
		String timeStamp = rs.getString("time");
		String author = rs.getString("username");
		String announcement = rs.getString("announcement");
		
		out.println ("<p>" + timeStamp + " by " + author + ":" + announcement);
		}
	}
%>
</body>
</html>
