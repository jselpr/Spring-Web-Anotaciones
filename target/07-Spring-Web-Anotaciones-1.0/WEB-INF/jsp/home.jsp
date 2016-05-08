<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="home.titulo"/></title>
        <spring:url value="/resources/css/main.css" var="mainCss" />
        <spring:url value="/resources/js/jquery.js" var="jqueryJs" />
        <spring:url value="/resources/js/main.js" var="mainJs" />

        <link href="${mainCss}" rel="stylesheet" />
        <script src="${jqueryJs}"></script>
        <script src="${mainJs}"></script>
    </head>

    <body>
        Clientes (<a href="agregar.do">Agregar Nuevo</a>)<br/>
        <c:forEach var="cliente" items="${clientes}">
            ${cliente.id}-${cliente.nombre}
            <a href="editar.do?id=${cliente.id}">Editar</a>
            <a href="eliminar.do?id=${cliente.id}">Eliminar</a>
            <br/>
        </c:forEach>
        <img src="<c:url value='/resources/collapse.gif'/>"/>
        <h1>1. Test CSS</h1>

        <h2>2. Test JS</h2>
        <div id="msg"></div>
    </body>
</html>
