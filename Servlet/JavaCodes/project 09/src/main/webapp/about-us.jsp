<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us Page</title>
</head>
<body>


	<%
	 String myname = (String) session.getAttribute("name_key");
	%>
	
	<h4>Welcome : <%= myname %></h4>
	<a href="home.jsp">Home</a> <br></br>
	<a href="profile.jsp">Profile</a>

</body>
</html>