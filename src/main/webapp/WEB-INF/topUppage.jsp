<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 19-03-2020
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

<div>
    <form name="topUp" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="topUp">
        Email:<br>
        <input type="text" name="email" value="">
        <br>
        Beløb:<br>
        <select class="form-control" name="amount" value="Beløb">
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="20">20</option>
            <option value="50">50</option>
            <option value="100">100</option>
            <option value="200">200</option>
            <option value="500">500</option>
            <option value="1000">1000</option>
        </select>
        <br>
        <input type="submit" value="Indsæt" onclick="topUp()">
        <input class="btn btn-primary" type="submit" value="Bestil" onclick="payStatus()" >
    </form>
</div>
${requestScope.topUp}

<script>
    function topUp() {
        alert("${requestScope.topUp}")
    }
</script>
</body>
</html>
