<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 19-03-2020
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/header.inc"%>

<div>
    <form name="login" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="login">
        Email:<br>
        <input type="text" name="email" value="">
        <br>
        Password:<br>
        <input type="password" name="password" value="">
        <br>
        <input type="submit" value="Log ind">
    </form>
</div>

<div>
    <a href="FrontController?taget=redirect&destination=registerpage"><button type="button">Eller registrer en ny bruger</button></a>
</div>

${sessionScope.msg}

<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>

</body>
</html>
