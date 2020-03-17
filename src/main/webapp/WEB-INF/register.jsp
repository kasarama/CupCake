<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 3/16/20
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create User page</title>
</head>
<body>

<td>
    <form name="register" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="register">
        Email:<br>
        <input type="text" name="email" value="someone@olskercupcakes.com">
        ${requestScope.email}
        <br>
        Password:<br>
        <input type="password" name="Indtast Kodeord" value="sesam">
        ${requestScope.password1}
        <br>
        Retype Password:<br>
        <input type="password" name="Indtast Kodeord igen" value="sesam">
        ${requestScope.password2}
        <br>
        <input type="submit" value="Opret bruger">
    </form>
</td>

//TODO: Error on register page if user exists. ex: "bruger eksistere, contact IT?"
<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>

</body>
</html>
