<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body>
<h1>Quiz Result: </h1>
<h3>Your score: <%= (Integer) request.getAttribute("Score") %></h3>
<h3>Time taken to complete Quiz: <%= request.getAttribute("elapsedTime") %></h3>
<p>Go back to <a href="homepage.jsp">Homepage</a></p>
</body>
</html>