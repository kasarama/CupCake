<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 19-03-2020
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

<div class="card-deck mb-3 text-center" style="padding:10px;">
    <h1>Oversigt over ordrer af alle kunder</h1>
</div>


<c:forEach var="customer" items="${requestScope.listOfOrdersOfCustomer}">
   <h3>Ordrer af kunde: ${customer.email}</h3>

        <c:forEach var="order" items="${customer.orders}">
            <div class="card-deck mb-3 text-center" style="padding:10px; border-style: groove;">
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
                        <th>sum: ${order.sum}kr</th>
                        <th></th>
                        <th><form name="removeOrder" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="removeOrder">
                            <input type="hidden" name="orderID" value="${order.id}">
                            <input type="text" class="outline-secondary" name="comment" value="Skriv kommentar her..." >
                            <input type="submit" class="btn btn-outline-secondary" value="Slet" onclick="other()">
                        </form>
                        </th>
                    </tr>
                </table>
            </div>
        </c:forEach>
</c:forEach>



<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>


<script>


    function other() {
        alert("Ordre vil blive sendt til arkiv med angivet tekst ")

    }




</script>

<%@include file="../includes/footer.inc"%>
