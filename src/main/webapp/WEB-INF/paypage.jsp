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

<div class="card-deck mb-3 text-center" style="padding:10px;">
    <h1>Tak fordi at du handlede hos os!</h1>
</div>
<div class="card-deck mb-3 text-center" style="padding:10px;">

    <h2>Din ny saldo er ${requestScope.saldo}</h2>
</div>

<a href="FrontController?taget=redirect&destination=index">Til forsiden</a>

<%@include file="../includes/footer.inc"%>
