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

<div class="container" >
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
            <h1>Øens bedste cupcakes!</h1>

            <h3>Vælg og bestil her:</h3>
        </div>
    </div>
</div>
<div class="container">

            <div class="form-row">
                <div class="form-group col-md-8 col-sm-8 col-lg-3">
                </div>
                <div class="form-group col-md-8 col-sm-8 col-lg-6">
                    <form name="addItems" action="FrontController" method="POST">
                        <input type="hidden" name="taget" value="newLine">
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

                <div class="form-group col-md-8 col-sm-8 col-lg-3">
                </div>
            </div>


</div>




<%@include file="includes/footer.inc"%>
