<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 19-03-2020
  Time: 01:44
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
<div class="container">
    <div class="container">
        <h3>Hello ${sessionScope.firstName} </h3>
    </div>
    <div class="container">
        <form name="showCart" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="showCart">
            <input class="btn btn-primary" type="submit" value="Indkøbskurv">
        </form>
    </div>
    <div class="container">
        <form name="home" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="home">
            <input class="btn btn-primary" type="submit" value="Vælg Cupcake">
        </form>
    </div>
    <div class="container">
        <form name="showOrders" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="showOrders">
            <input class="btn btn-primary" type="submit" value="Vis tidligere bestillinger">
        </form>
    </div>

</div>


</body>
</html>
