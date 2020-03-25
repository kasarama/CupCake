<%--
  Created by IntelliJ IDEA.
  User: magda
  Date: 19-03-2020
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

<div class="container"  style="padding:10px;">


    <div class="card-deck mb-3 text-center">
        <div class="card mb-4 shadow-sm">


        <form name="topUp" class="form-inline" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="topUp">

            <div class="form-group mx-sm-3 mb-2">

                <label for="email" class="sr-only">Password</label>
                <input type="text" name="email" class="form-control" id="email" placeholder="e-mail">
            </div>
           <!-- <input type="text" name="email" value="">-->
            <div class="form-group mx-sm-3 mb-2">

            <label for="amount" class="sr-only">Beløb</label>
            <select class="form-control" name="amount"  id="amount" value="Beløb">
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="200">200</option>
                <option value="500">500</option>
                <option value="1000">1000</option>
            </select>
            </div>
            <div class="form-group mx-sm-3 mb-2" style="padding:10px;">

                <button type="submit" class="btn btn-primary mb-2" value="Indsæt" onclick="topUp()">Indsæt</button>
            </div>
        </form>
    </div>

    </div>
</div>
${requestScope.topUp}


<c:if test = "${requestScope.error!= null}" >

    <h2>Error ! </h2>
    ${requestScope.error}

</c:if>

<script>
    function topUp() {
        alert("${requestScope.topUp}")
    }
</script>

<%@include file="../includes/footer.inc"%>
