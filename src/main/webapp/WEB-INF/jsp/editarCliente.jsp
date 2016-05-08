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
        <h1>Editar Cliente</h1>
        <form:form commandName="cliente" action="editar.do" method="POST">
            <input type="hidden" name="POST" value="POST"/>
            <form:hidden path="id"/>
            <form:input path="nombre"/>
            <form:errors path="nombre"/>
            <br/>
            <input type="submit" name="enviar"/>
        </form:form>
    </body>
</html>
