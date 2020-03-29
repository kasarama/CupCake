<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 19-03-2020
  Time: 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>



<div class="container"  style="padding:10px;">
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
        </div>
    </div>
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
            <h2>${requestScope.registerMSG}</h2>
        </div>
    </div>
    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">
            <form name="register" action="FrontController" method="POST" onsubmit="required()">
                <input type="hidden" name="taget" value="register">

                Email:<br>
                <input type="email" name="email" value="${requestScope.givenemail}" required>
                <br>
                Adgangskode:<br>
                <input type="password" name="password1" value="" required>
                <br>
                Gentag adgangskode:<br>
                <input type="password" name="password2" value="" required>
                <br>
                Fornavn:<br>
                <input type="text" name="fName" value="${requestScope.givenfName}" required>
                <br>
                Efternavn:<br>
                <input type="text" name="lName" value="${requestScope.givenelName}" required>
                <br>
                <input class="btn btn-primary" style="padding: 10px;" type="submit" value="Registrer" >
            </form>
        </div>
    </div>



</div>


        <c:if test = "${requestScope.error!= null}" >
        <div class="card-deck mb-3 text-center" style="padding:10px;">
            <h2>Error ! </h2>
            ${requestScope.error}
        </div>
        </c:if>
    </div>

<script>
    function required()
    {
       alert('Behandling af indtastede data er i gang...');

    }

</script>

<%@include file="../includes/footer.inc"%>
