<%--
  Created by IntelliJ IDEA.
  User: monajakobmeshal
  Date: 3/17/20
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- This is the title that'll be displayed in the browser window "tab" -->
    <title>Login page</title>
</head>

<body>
<h1>Velkommen ombord!</h1>
<h4>Log in hvis du allerede er en bruger.</h4>

<br>
<!--This sessionScope works with the Login
 session: communication session between a browser and the server.
 print out the requested message, "as long as the session lives"-->
${sessionScope.message}
<!--This requestScope works with the Login class
 print out the requested message, "as long as the requestScope lives"-->
${requestScope.message}
<br>

<!-- ** Creating new user field and button ** -->
<!-- action: do action on this server, method: do the action using this method from the server file -->
<!-- action: the data/text to be posted/gotten by server to browser -->
<form name="login" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="login">
    <label for="fname">Email:</label><br>
    <input type="text" id="fname" name="email"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="password" id="lname" name="password" value="sesam"> <br><br>
    <input type="submit" value="Login">
</form>

<c:if test = "${requestScope.error!= null}" >

    <h4>Der gik noget galt!</h4>
    ${requestScope.error}
</c:if>

</body>
</html>