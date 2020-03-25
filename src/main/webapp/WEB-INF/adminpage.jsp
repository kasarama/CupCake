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

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>




