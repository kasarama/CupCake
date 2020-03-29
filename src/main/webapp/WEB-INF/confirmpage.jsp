<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 17-03-2020
  Time: 01:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
du er logget ind som ${sessionScope.email}
<h2>Saldo: ${requestScope.saldo}</h2>
<h1>Din bestiling:</h1>

<h3>Her kan du se en oversigt af de cupcakes du vil bestille:</h3>


<div class="card-deck mb-3 text-center" style="padding:10px;">
    <table class="table table-sm">

        <tr>
            <th>Bund</th>
            <th>Top</th>
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
                <form name="showCart" action="FrontController" method="POST">
                    <input type="hidden" name="taget" value="showCart">
                    <input class="btn btn-primary" type="submit" value="Tilbage til indkøbskurv">
                </form>

            </th>
            <th>
                <form name="pay" action="FrontController" method="POST">
                    <input type="hidden" name="taget" value="pay">
                    <input class="btn btn-primary" type="submit" value="Betal" onclick="msgPaid()">
                </form>
            </th>
        </tr>
    </table>

    <div class="card-deck mb-3 text-center" style="padding:10px;">
        ${requestScope.saldoToLow}
    </div>


<script>
    function msgPaid() {
        alert("Tak for betaling! Vi skynder os til at lave dine Cupcakes færdigt!")

    }
</script>
<%@include file="../includes/footer.inc"%>
