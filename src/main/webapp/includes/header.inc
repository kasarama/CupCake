<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Olsker Cupcakes</title>
</head>

<body>
<div class="container">

<!-- Navigation -->
    <div class="container">
        <div class="container">
            <img src="img/olskercupcakes.png" class="img-fluid mb-4">
        </div>


        <div class="container">
            <ul class="nav nav-pills nav-fill">



                <c:set var="val" value="${sessionScope.email}"/>
                <c:choose>
                    <c:when test="${val == null}">
                        ${null}
                    </c:when>
                    <c:when test="${val == 'admin@olsker.cupcakes'}">
                <li class="nav-item">
                        <a href="FrontController?taget=redirect&destination=adminpage">
                            <button type="button" class="btn btn-outline-secondary">Administration</button>
                        </a>
                </li>
                    </c:when>
                    <c:otherwise>

                <li class="nav-item">
                        <form name="home" action="FrontController" method="post">
                            <input type="hidden" name="taget" value="home">
                            <input class="btn btn-outline-secondary" type="submit" value="Olsker Cupcakes">
                        </form>
                </li>

                <li class="nav-item">
                        <a href="FrontController?taget=redirect&destination=customerpage">
                            <button type="button" class="btn btn-outline-secondary">Min side</button>
                        </a>
                </li>

                    </c:otherwise>
                </c:choose>


                <c:set var="val" value="${sessionScope.email}"/>
                <c:choose>
                    <c:when test="${val == 'admin@olsker.cupcakes'}">

                <li class="nav-item">
                        <a href="FrontController?taget=redirect&destination=topUppage">
                            <button type="button" class="btn btn-outline-secondary">Top-Up</button>
                        </a>
                </li>

                <li class="nav-item">
                        <form name="allCustomers" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="allCustomers">
                            <input class="btn btn-outline-secondary" type="submit" value="Vis Kunder">
                        </form>
                </li>

                <li class="nav-item">
                        <form name="allOrders" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="allOrders">
                            <input class="btn btn-outline-secondary" type="submit" value="Vis Ordrer">
                        </form>
                </li>

                    </c:when>

                    <c:when test="${val == null}">
                        ${null}
                    </c:when>

                    <c:otherwise>

                <li class="nav-item">
                        <form name="showOrders" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="showOrders">
                            <input class="btn btn-outline-secondary" type="submit" value="Mine ordrer">
                        </form>
                </li>

                    </c:otherwise>
                </c:choose>


                <c:set var="val" value="${sessionScope.email}"/>
                <c:choose>
                    <c:when test="${val == null}">
                        ${null}
                    </c:when>
                    <c:otherwise>

                <li class="nav-item">
                        <form name="logOut" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="logOut">
                            <input type="submit" class="btn btn-outline-secondary" value="Log ud">
                        </form>
                </li>
                    </c:otherwise>
                </c:choose>

                <c:set var="val" value="${sessionScope.email}"/>
                <c:choose>
                    <c:when test="${val == null}">

                <li class="nav-item">
                        <a href="FrontController?taget=redirect&destination=loginpage">
                            <button type="button" class="btn btn-outline-secondary">Log ind</button>
                        </a>
                </li>
                    </c:when>
                    <c:otherwise>

                <li class="nav-item">
                        <span class="navbar-text" >Du er logget ind som ${sessionScope.email}</span>
                </li>
                    </c:otherwise>
                </c:choose>


                <c:set var="val" value="${sessionScope.email}"/>
                <c:choose>
                    <c:when test="${val == 'admin@olsker.cupcakes'}">
                        ${null}
                    </c:when>
                    <c:otherwise>
                <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0" name="showCart" action="FrontController" method="POST">
                            <input type="hidden" name="taget" value="showCart">
                            <button type="button" class="btn btn-outline-secondary">
                                <input type="image" class="object-fit:cover" src="img/cart.png" width="30" height="25" alt="Submit">${requestScope.cart}
                            </button>
                        </form>
                </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>

    </div>