<%-- 
    Document   : edit-customer
    Created on : 2014-11-19, 10:54:54
    Author     : instruktor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <a href="<c:url value="/customer/add?locale=en"/>">[en]</a>
        <a href="<c:url value="/customer/add?locale=pl"/>">[pl]</a>
        current: ${pageContext.response.locale}
        <hr>
        
        
        
        <h1>Edycja danych klienta </h1>
        
        ${customer.name}<br>
        
        <form:form htmlEscape="true" modelAttribute="customer" method="POST" action="/customer/save">
            <spring:message var="customerName" code="customer.name"/>
            <spring:message code="customer.name"/>:<form:input htmlEscape="true" placeholder="${customerName}" path="name"/>
            <form:errors cssClass="error" path="name"/> <br>
            
            <spring:message var="customerNip" code="customer.nip"/>
            ${customerNip}: <form:input placeholder="NIP" path="nip"/>
            <form:errors cssClass="error" path="nip"/><br>
            
            <spring:message var="customerDiscount" code="customer.discount"/>
            ${customerDiscount}: <form:input placeholder="${customerDiscount}" path="discount"/>
            <form:errors cssClass="error" path="discount"/><br>
            
            <spring:message var="customerEmail" code="customer.email"/>
            ${customerEmail}: <form:input placeholder="${customerEmail}" path="email"/>
            <form:errors cssClass="error" path="email"/><br>
            
            <form:input placeholder="Date" path="date"/>
            <form:errors cssClass="error" path="date"/><br>
            
            <form:button>Zapisz</form:button>
        </form:form>
        
            
            
            <a href="<c:url value="/customer/add"/>">anuluj</a>
            
            <hr>
            Stopka:<br>
            <spring:message code="name"/> : <spring:message code="version"/>
    </body>
</html>
