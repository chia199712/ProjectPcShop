<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, shoppingPackage.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String ind = request.getParameter("index");
		int itemPageIndex = Integer.parseInt(ind);

  	    shoppingDB.setItemPageIndex(itemPageIndex);
		
  	  	out.println(shoppingDB.getItemPage_name() + "<br>");
  	    out.println(shoppingDB.getItemPage_info() + "<br>");
		%>
		
	<%-- 
		處理購物車 搭配下一行input
		<form action="" method="GET"></form>
	 --%>
	
</body>
</html>