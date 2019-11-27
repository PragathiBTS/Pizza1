<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix='sql' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<br>
<center><b>Order Successfully placed with the order id:<%=request.getAttribute("orderid")
%></center></b>
<br>
<br>
<center><img src="https://d1j8pt39hxlh3d.cloudfront.net/uploads/party_face_256_1.gif" alt=" "></center>

<br>
<a href="Index.jsp">Home</a><br>
<!-- <a href="exitorder.jsp">Exit</a> -->
</body>
</html>