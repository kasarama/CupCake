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



        <div class="row" style=" padding:15px;">

            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Velkommen ombord ${sessionScope.firstName}!</h5>
                        <p class="card-text">Det er godt at se dig igen!</p>

                    </div>
                </div>
            </div>


            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Indkøbskurv</h5>
                        <p class="card-text">Se hvilke lækkerier du har i din kurv</p>
                        <form name="showCart" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="showCart">
                            <input class="btn btn-primary" type="submit" value="Vælg">
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Vælg din Cupcake</h5>
                        <p class="card-text">Vælg din yndlings bund og sprøjt noget lækkert topping på den</p>
                        <form name="home" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="home">
                            <input class="btn btn-primary" type="submit" value="Vælg">
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Vis tidligere bestillinger</h5>
                        <p class="card-text">Se hvad du havde allerede bestilt hos os</p>
                        <form name="showOrders" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="showOrders">
                            <input class="btn btn-primary" type="submit" value="Vælg">
                        </form>
                    </div>
                </div>
            </div>



        </div>
    </div>



<%@include file="../includes/footer.inc"%>
