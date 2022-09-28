<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, shoppingPackage.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="shopServletTest" method="GET">
		<%
		out.println(shoppingDB.getItemPageIndex() + "<br>");
		out.println(shoppingDB.getItemPage_name() + "<br>");
		out.println(shoppingDB.getItemPage_info() + "<br>");
		%>
	</form>
</body>
</html>