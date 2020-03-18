<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 13-03-2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form name="removeItem" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="removeItem">
                <input type="hidden" name="bottom" value="${item[0]}">
                <input type="hidden" name="topping" value="${item[1]}">
                    <th>${item[0]}</th>
                    <th>${item[1]}</th>
                    <th>${item[2]}</th>
                    <th>${item[3]}</th>
                    <th><input type="submit" value="Slet " onclick="removItem()" ></th>

            </form>
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
            <input type="submit" value="Bestil" onclick="payStatus()" >
        </form>
        </th>

        <th>
            <form name="saveOrder" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="saveOrder">
                <input type="submit" value="Gem" onclick="msgSaved()">
            </form>
        </th>

        <th>
            <a href="FrontController?taget=redirect&destination=index"><button type="button">Tilføj flere</button></a>
        </th>
    </tr>
</table>

${requestScope.payStatus}



<script>
    function msgSaved() {
        alert("Du kan fortsætte med din ordre når du er tilbage")
    }

    function payStatus() {
        var msg = "${requestScope.payStatus}"
        alert(msg)
    }

    function removeItem() {
        alert("Cupcake slettet fra indkøbskurven")
    }
    function fill() {
        alert("Dine gemte Cupcakes er nu i din indkæbskurv")
    }


</script>
</body>
</html>