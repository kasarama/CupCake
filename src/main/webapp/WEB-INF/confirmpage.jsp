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
        <th><form name="showCart" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="showCart">
            <input type="submit" value="Tilbage til indkøbskurv">
        </form>

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
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>