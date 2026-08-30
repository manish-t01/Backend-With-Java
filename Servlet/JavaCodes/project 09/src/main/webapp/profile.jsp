<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	
	<%
	 String myname = (String) request.getAttribute("name_key");
	%>
	
	<h4>Welcome : <%= myname %></h4>
	
</body>
</html>