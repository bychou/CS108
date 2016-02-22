<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Statement, java.sql.ResultSet, java.util.*, java.text.SimpleDateFormat" %>
<%@ page import="web.QuizManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Quiz Question</title>
</head>
<body>
<h2>Add Question <%= request.getSession().getAttribute("currentQuestion") %> of <%= request.getSession().getAttribute("numQuestion") %> </h2>
<p>Select Question type to be added from below:</p>
<form action="QuestionServlet" method="post">
<p><input name="questionType" type="hidden" value="QuestionResponse"/>
<input type="submit" value="Question-Response"></p>
</form>
<form action="QuestionServlet" method="post">
<p><input name="questionType" type="hidden" value="FillBlank"/>
<input type="submit" value="Fill in the Blank"></p>
</form>
<form action="QuestionServlet" method="post">
<p><input name="questionType" type="hidden" value="MultipleChoice"/>
<input type="submit" value="Multiple Choice"></p>
</form>
<form action="QuestionServlet" method="post">
<p><input name="questionType" type="hidden" value="PictureResponse"/>
<input type="submit" value="Picture-Response Questions"></p>
</form>
</body>
</html>