<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 17-03-2020
  Time: 01:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bekræft bestilling</title>
</head>
<body>
<h2>Saldo: ${requestScope.saldo}</h2>
<h1>Din bestiling:</h1>

<h3>Her kan du se en oversigt af de cupcakes du vil bestille:</h3>



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
           <a href="FrontController?taget=redirect&destination=cartpage"><button type="button">Tilbage</button></a>
        </th>
        <th>
            <form name="pay" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="pay">
                <input type="submit" value="Betal" onclick="msgPaid()">
            </form>
        </th>
    </tr>
</table>

${requestScope.saldoToLow}


<script>
    function msgPaid() {
        alert("Tak for betaling! Vi skynder os til at lave dine Cupcakes færdigt!")

    }


</script>
</body>
</html>
