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
<h1>Her is the cart page</h1>





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

<%
    out.println("Loop will run 5 times.<br>");
    int i = 1;
    // while loop that runs five times
    while (i<6) {
        out.println("we are in loop value is : "+i+"<br>");
        i++;
    }
    out.println("Now we are out of while loop.");
%>


<script>
    function msg() {
        alert("Du kan fortsætte med din ordre når du er tilbage")
    }
</script>
</body>
</html>
