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
<h1>Her is the cart page</h1>

<table>
    <tr>
        <th>Bund</th>
        <th>Topping</th>
        <th>Pris</th>
        <th>Antal</th>
    </tr>
    <tr>
        <th>a</th>
        <th>b</th>
        <th>c</th>
        <th>d</th>
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
                <input type="submit" value="Gem" onclick="msg()">
            </form>
        </th>
    </tr>
</table>

<script>
    function msg() {
        alert("Du kan fortsætte med din ordre når du er tilbage")
    }
</script>
</body>
</html>
