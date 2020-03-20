<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 18-03-2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

        order oversigt

<c:forEach var="order" items="${requestScope.ordersArray}">
    <div class="container">
        <table class="table table-sm">
            <tr>
                <th>Ordre nr: ${order.id}</th>
                <th>Bund</th>
                <th>Topping</th>
                <th>Antal</th>
            </tr>

            <c:forEach var="cupcake" items="${order.products}">
                <tr>
                    <th></th>
                    <th>${cupcake.key.bottom}</th>
                    <th>${cupcake.key.topping}</th>
                    <th>${cupcake.value}</th>
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
