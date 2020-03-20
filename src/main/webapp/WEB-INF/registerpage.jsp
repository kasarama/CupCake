<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 19-03-2020
  Time: 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
<div>
    <form name="register" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="register">
        Email:<br>
        <input type="text" name="email" value="">
        <br>
        Adgangskode:<br>
        <input type="password" name="password1" value="">
        <br>
        Gentag adgangskode:<br>
        <input type="password" name="password2" value="">
        <br>
        Fornavn:<br>
        <input type="text" name="fName" value="">
        <br>
        Efternavn:<br>
        <input type="text" name="sName" value="">
        <br>
        <input type="submit" value="Registrer">
    </form>
</div>

</body>
</html>
