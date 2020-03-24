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
<h1>Oversigt over ordrer af alle kunder</h1><br><br><br>



<c:forEach var="customer" items="${requestScope.listOfOrdersOfCustomer}">
<div class="container">

    Ordrer af kunde: ${customer.email}

        <c:forEach var="order" items="${customer.orders}">
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
                        <th>sum: ${order.sum}kr</th>
                        <th></th>
                        <th><form name="removeOrder" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="removeOrder">
                            <input type="hidden" name="orderID" value="${order.id}">
                            <input type="text" class="outline-secondary" name="comment" value="Skriv kommentar her..." >
                            <input type="submit" class="btn btn-outline-secondary" value="Slet" onclick="other()">

                          <!--      <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="Ubetalt" onclick="unpaid()">
                                    <label class="form-check-label" for="inlineRadio1">Ubetalt</label>
                                </div>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="Retur" onclick="retur()">
                                    <label class="form-check-label" for="inlineRadio2">Retur</label>
                                </div>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="Tilbud" onclick="promo()">
                                    <label class="form-check-label" for="inlineRadio3">Tilbud</label>
                                </div>

                                <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" value="Andet" oninput="com()">
                                <input type="text" for="inlineRadio4" name="other" value="Andet..." oninput="com()">

                                </div>

                                <div class="form-check form-check-inline">
                                    <input type="submit" value="Send" >
                                </div> -->

                        </form>
                        </th>

                    </tr>


                </table>
            </div>
        </c:forEach>


</div>
</c:forEach>


<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>


<script>
    function unpaid() {
        alert("Ordre vil blive sendt til arkiv som 'Ubetalt'")
    }

    function retur() {
        alert("Ordre vil blive sendt til arkiv som 'Retur'")
    }

    function promo() {
        alert("Ordre vil blive sendt til arkiv som 'Tilbud'")
    }

    function other() {
        alert("Ordre vil blive sendt til arkiv med angivet tekst ")

    }

    function unpaid() {
        alert("Ordre vil blive sendt til arkiv som 'Ubetalt'")
    }


</script>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>