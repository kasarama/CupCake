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
    <div class="card-deck mb-3 text-center" style="padding:10px;">
        <table class="table table-sm">
            <tr>
                <th>Bund</th>
                <th>Top</th>
                <th>Pris</th>
                <th>Antal</th>
            </tr>

            <c:forEach var="cupcake" items="${order.products}">
                <tr>
                    <th>${cupcake.key.bottom}</th>
                    <th>${cupcake.key.topping}</th>
                    <th style="text-align: left">${cupcake.key.price} kr</th>
                    <th>${cupcake.value} stk.</th>
                </tr>
            </c:forEach>


            <tr>
                <th></th>
                <th style="text-align: right">Sum:</th>
                <th style="text-align: left">${order.sum} kr</th>
                <th>${order.items()} stk.</th>
            </tr>


        </table>
    </div>
</c:forEach>

<%@include file="../includes/footer.inc"%>
