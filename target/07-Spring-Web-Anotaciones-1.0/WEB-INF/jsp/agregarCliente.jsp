<%-- 
    Document   : agregarCliente
    Created on : 02-sep-2009, 16:32:55
    Author     : odeen
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar Cliente</h1>
        ${fecha}<br/>
        <form:form action="agregar.do" modelAttribute="cliente">
            <form:input path="nombre" id="nombre"/>
            <form:errors path="nombre"/>
            <select onclick="javascript:document.getElementById('nombre').value=this.value">
                <c:forEach var="nombre" items="${clientesTipicos}">
                    <option value="${nombre}">${nombre}</option>
                </c:forEach>
            </select>
            <br/>
            <spring:message var="enviar" code="enviar"/>
            <input type="submit" name="enviar" value="${enviar}"/>
        </form:form>
        <form action="" method="post">
            <input type="text" name="nombre" id="nombre2"/>
            <select onclick="javascript:document.getElementById('nombre2').value=this.value">
                <c:forEach var="nombre" items="${clientesTipicos}">
                    <option value="${nombre}">${nombre}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" name="enviar"/>
        </form>
    </body>
</html>
