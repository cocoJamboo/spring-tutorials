<%-- 
    Document   : display
    Created on : 2014-11-20, 09:39:39
    Author     : instruktor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>zamówienie nr ${order.id}</h1>
        
        data: ${order.orderDate}<br>
        
        <h4>pozycje zamówienia</h4>
        
        <c:forEach items="${order.orderList}" var="item">
            ${item.amount} ${item.product.name}<br>
        </c:forEach>
        
    </body>
</html>
