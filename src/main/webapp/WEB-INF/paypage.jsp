<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 14-03-2020
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
<h1>Tak fordi at du handlede hos os!</h1>
<h2>Din ny saldo er ${requestScope.saldo}</h2>

<a href="FrontController?taget=redirect&destination=index">Til forsiden</a>

</body>
</html>
