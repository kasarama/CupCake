<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 13-03-2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
<h1>Kurv</h1>

<c:set var="val" value="${requestScope.saldo}"/>
<c:choose>
    <c:when test="${val == null}">
        ${null}
    </c:when>
    <c:otherwise>
        <h2>Saldo: ${requestScope.saldo}</h2>
    </c:otherwise>
</c:choose>




<c:set var="val" value="${requestScope.cart}"/>
<c:choose>
    <c:when test="${val == '0'}">

        <h3>Din indkøbskurv ser tomt ud...</h3>
        <a href="FrontController?taget=redirect&destination=index"><button class="btn btn-primary" type="button">Find nogle Cupcakes her</button></a>



    </c:when>
    <c:otherwise>


        <h3>Sikkert nogle fine Cupcakes du har valgt!</h3>

        <table class="table table-sm">
            <tr>
                <th>Bund</th>
                <th>Topping</th>
                <th>Pris</th>
                <th>Antal</th>
            </tr>
            <c:forEach var="item" items="${requestScope.items}">
                <tr>
                    <form name="removeItem" action="FrontController" method="POST">
                        <input type="hidden" name="taget" value="removeItem">
                        <input type="hidden" name="bottom" value="${item[0]}">
                        <input type="hidden" name="topping" value="${item[1]}">
                        <th>${item[0]}</th>
                        <th>${item[1]}</th>
                        <th>${item[2]}</th>
                        <th>${item[3]}</th>
                        <th><input type="submit" value="Slet " onclick="removItem()" ></th>

                    </form>
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

                    <c:set var="val" value="${sessionScope.email}"/>
                    <c:choose>
                        <c:when test="${val == null}">
                            <form name="login" action="FrontController" method="POST">
                                <input type="hidden" name="taget" value="login">
                                <input type="hidden" name="origin" value="cartpage">
                                <input class="btn btn-primary" type="submit" value="Bestil Cupcakes" onclick="loginFirst()">
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form name="confirmOrder" action="FrontController" method="POST">
                                <input type="hidden" name="taget" value="confirmOrder">
                                <input class="btn btn-primary" type="submit" value="Bestil" onclick="payStatus()" >
                            </form>
                        </c:otherwise>
                    </c:choose>
                </th>

                <th>
                    <form name="home" action="FrontController" method="post">
                        <input type="hidden" name="taget" value="home">
                        <input class="btn btn-primary" type="submit" value="Tilføj fere">
                    </form>

                </th>
            </tr>
        </table>



    </c:otherwise>
</c:choose>





<script>
    function payStatus() {

        alert("${requestScope.payStatus}")
    }

    function loginFirst() {
        alert("Du skal log ind først")

    }
</script>
<script>
    function removeItem() {
        alert("Cupcake slettet fra indkøbskurven")
    }
</script>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>