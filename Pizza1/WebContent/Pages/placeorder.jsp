<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix='sql' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Order Details</title>
</head>
<body> <!-- bgcolor=#cc3333> -->
<form action="PizzaController1">

<br>
<center><h1>ENTER THE DETAILS:</h1>></center>
<br>
<center><img src="http://bestanimations.com/Food/FastFood/Pizza/pizza-animated-gif-33.gif" alt="pizza"></center>
<br>
<center><b>Name:<Input type="text" name=name></b></center><br>
<center><b>Address:<Input type="text" name=address></b></center><br>
<center><b>Contact no:<Input type="text" name=phoneno></b></center><br>
<center><b>Toppings Prefered:</b>
<select name="toppings">
<c:forEach var="choic" items="${requestScope.toppingpreferred}">
<option value="${choic.value}">${choic.value} </option>
</c:forEach>
</select></center>
<input type="submit" value="place order">

</form>

</body>
</html>