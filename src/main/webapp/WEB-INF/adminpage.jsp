<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 13-03-2020
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>



<div class="container"  style="padding:10px;">
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
            <img src="img/cart.png" class="card-img-top" alt="Ordrer">
            <div class="card-body">
                <h5 class="card-title">Ordrer</h5>
                <p class="card-text">Viser oversigt over ordrer af alle dine dejlige kunder.</p>
                <form name="allOrders" action="FrontController" method="POST">
                    <input type="hidden" name="taget" value="allOrders">
                    <input class="btn btn-primary" type="submit" value="Vis mig dem alle!">
                </form>
            </div>
        </div>

        <div class="card mb-4 shadow-sm">
            <img src="img/eat.jpg" class="card-img-top" alt="Kunder">
            <div class="card-body">
                <h5 class="card-title">Kunder</h5>
                <p class="card-text">Viser oversigt over alle kunder med nummre og sum af deres ordrer.</p>
                <form name="allCustomers" action="FrontController" method="POST">
                    <input type="hidden" name="taget" value="allCustomers">
                    <input class="btn btn-primary" type="submit" value="Jeg vil gerne kigge!">
                </form>
            </div>
        </div>

        <div class="card mb-4 shadow-sm">
            <img src="img/topup.jfif" class="card-img-top" alt="Top-Up">
            <div class="card-body">
                <h5 class="card-title">Top-Up</h5>
                <p class="card-text">Her findes en form for at opdatere kundens saldo.</p>
                <a href="FrontController?taget=redirect&destination=topUppage">
                    <button type="button" class="btn btn-primary">Nu skal de få deres penge på kontoen</button>
                </a>
            </div>
        </div>
    </div>
</div>



<%@include file="../includes/footer.inc"%>
