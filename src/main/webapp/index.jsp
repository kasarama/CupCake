<%@ page import="FunctionLayer.OrderLines" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="includes/header.inc"%>


<%!
    @Override
    public void jspInit() {
        OrderLines.initOrder();
    }
%>
<%
    request.setAttribute("orderlines", OrderLines.getOrder());
%>


<div>
    <h1>Øens bedste cupcakes!</h1>

    <h3>Vælg og bestil her:</h3>
</div>


<div class="form-row">
    <div class="form-group col-md-8 col-sm-8 col-lg-6">
    <form name="addItems" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="newLine">
        <br>
        Vælg bund
        <select class="form-control"name="bottom" placeholder="Vælg bund">
            <option value="Chocolate">Chocolate</option>
            <option value="Vanilla">Vanilla</option>
            <option value="Nutmeg">Nutmeg</option>
            <option value="Pistacio">Pistacio</option>
            <option value="Almond">Almond</option>
        </select>
        <br>
        Vælg topping
        <select class="form-control" name="topping" value="Vælg topping">
            <option value="Chocolate">Chocolate</option>
            <option value="Blueberry">Blueberry</option>
            <option value="Rasberry">Rasberry</option>
            <option value="Crispy">Crispy</option>
            <option value="Strawberry">Strawberry</option>
            <option value="RumRaisin">RumRaisin</option>
            <option value="Orange">Orange</option>
            <option value="Lemon">Lemon</option>
            <option value="BlueCheese">BlueCheese</option>
        </select>
        <br>
        Vælg antal
        <input class="form-control" type="number" name="quantity" value=1 min="1" max="50">
        <input class="btn btn-primary" type="submit" value="Læg i kurv" >
    </form>
    </div>
</div>


<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>