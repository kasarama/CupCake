<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 20-03-2020
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
<h1>Oversigt over alle kunder og derers ordrer</h1><br><br><br>

<div class="container">
<table class="table table-sm">
    <tr>
        <th>e-mail</th>
        <th>fornavn</th>
        <th>efternavn</th>
        <th>saldo</th>
        <th colspan="2">ordrer</th>
    </tr>

    <c:forEach var="customer" items="${requestScope.allCustomers}">
    <tr>
        <td>${customer.email}</td>
        <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
        <td>${customer.saldo}</td>
        <td>ordre ID</td>
        <td>sum</td>
    </tr>
        <c:forEach var="order" items="${customer.orders}">
            <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>${order.id}</td>
            <td>${order.sum}</td>
            </tr>
        </c:forEach>

    </c:forEach>

</table>
</div>


</body>
</html>
