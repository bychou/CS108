<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= request.getSession().getAttribute("username") %>'s friend request</title>
</head>
<body>
	<%
		
		UserDataManager userDataManager = (UserDataManager) request.getServletContext().getAttribute("User Data Manager");
		ResultSet rs = userDataManager.getUserFriendRequests((String)request.getSession().getAttribute("username"));
		
		
		out.println("<h2>Your Friend Request</h2>");
		/* Check if there is any message. */
		if (!rs.isBeforeFirst()) { /* Have no message. */  
			out.println("You have no new friend request.");
		} else {
			while (rs.next()) { 
				out.println("<p>From: " + rs.getString("fromUser") + ", To: "+ rs.getString("toUser") + ", Message: " + rs.getString("Message") + "</p>");
			}		
		}
		
	%>
	
	
<form action="FriendRequestServlet" method="post">
<h2>Send a Friend Request</h2>
<p>Receiver<input type="text" name="toUser"></p>
<p>Message<input type="text" name="message"></p>
<input type="submit" value="send request">
</form>
	<%
		String returnStatus = (String) request.getAttribute("Return Status");
		if ( returnStatus != null) {
			out.println(returnStatus);
		}
	%>


</body>
</html>