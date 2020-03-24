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

<div class="container">
    <form name="login" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="login">
        Email:<br>
        <input type="email" name="email" value="" onsubmit="required()">
        <br>
        Password:<br>
        <input type="password" name="password" value="" onsubmit="required()">
        <br>
        <input class="btn btn-primary" type="submit" value="Log ind">
    </form>
</div>

<div>
    <a href="FrontController?taget=redirect&destination=registerpage"><button type="button" class="btn btn-primary">Eller registrer</button></a>
</div>

<div class="container">
<c:if test = "${requestScope.errorMSG!= null}" >

    <h2>${requestScope.errorMSG}</h2>

</c:if>
</div>
<script>
    // If the length of the element's string is 0 then display helper message
    function required(inputtx)
    {
        if (inputtx.value.length == 0)
        {
            alert("message");
            return false;
        }
        return true;
    }

</script>
</body>
</html>
