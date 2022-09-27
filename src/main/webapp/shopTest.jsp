<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, shopTestPackage.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shopPageTest</title>
</head>
<body>
	<h1>全部商品</h1>
	<hr><br>
	<form action = "shopServletTest" method = "POST">
		<table border="1px" cellpadding="0" cellspacing="0">
			<%
			for (int i = 0; i < shopDB.size(); i++) {
				out.println("<tr>");
				out.println("<td>" + shopDB.getItName(i) + "</td>");
				out.println("<td><a href='./shopDetailTest.jsp?itName=" + shopDB.getItName(i) + "'>" + shopDB.getItDetail(i) + "</a>" + "</td>");
				out.println("<td>" + shopDB.getItPrice(i) + "</td>");
				out.println("<td><img src='" + shopDB.getItImg(i) + "' alt='" + shopDB.getItName(i) + " '></td>");
				out.println("</tr>");
			}
		%>
		</table>
	</form>
</body>
</html>