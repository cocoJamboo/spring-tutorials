<%-- 
    Document   : home
    Created on : 2013-03-03, 14:57:19
    Author     : Adrian Lapierre <alapierre@softproject.com.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        Hallo ${name}!!!
        <br>
        masz lat: ${age}
        
        
        <hr>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            Jesteś administrotorem <sec:authentication property="principal.username"/>
        </sec:authorize>
        
        <sec:authorize url="/admin">
            masz dosttęp do <a href="<c:url value="/admin"/>">admin</a>
        </sec:authorize>
    </body>
</html>
