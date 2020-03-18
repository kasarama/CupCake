<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 18-03-2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrdrerOversigt</title>
</head>
<body>
     Here comes list of all the orders of a customer




<c:forEach var="order" items="${requestScope.orders}">
    <div>
        <table>
            <tr>
                <th>Ordre nr: ${order.id}</th>
                <th>Bund</th>
                <th>Topping</th>
                <th>Antal</th>
            </tr>

            <c:forEach var="ciastko" items="${order.products}">
                <tr>
                    <th></th>
                    <th>${ciastko.key.bottom}</th>
                    <th>${ciastko.key.topping}</th>
                    <th>${ciastko.value}</th>
                </tr>
            </c:forEach>


            <tr>
                <th></th>
                <th>Sum</th>
                <th>${order.sum}</th>
                <th>kr</th>
            </tr>


        </table>
    </div>
</c:forEach>







</body>
</html>
