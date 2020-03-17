<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 13-03-2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kurv</title>
</head>
<body>
<h1>Kurv</h1>
<h2>Saldo: ${requestScope.saldo}</h2>
<h3>Her kan du se en oversigt af kurvens indhold:</h3>



<table>
    <tr>
        <th>Bund</th>
        <th>Topping</th>
        <th>Pris</th>
        <th>Antal</th>
    </tr>

<c:forEach var="item" items="${requestScope.items}">
    <tr>
            <c:forEach var="detail" items="${item}">
                <th>${detail}</th>
            </c:forEach>

    </tr>
</c:forEach>
    <tr>
        <th>I alt:</th>
        <th></th>
        <th></th>
        <th>${requestScope.sum}</th>
    </tr>


    <tr>
        <th>
        <form name="confirmOrder" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="confirmOrder">
            <input type="submit" value="Bestil" >
        </form>
        </th>
        <th>
            <form name="saveOrder" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="saveOrder">
                <input type="submit" value="Gem" onclick="msgSaved()">
            </form>
        </th>
    </tr>
</table>

<script>
    function msgSaved() {
        alert("Du kan fortsætte med din ordre når du er tilbage")
    }

</script>
</body>
</html>
