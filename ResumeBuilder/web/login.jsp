<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@ include file="link-css.html" %> 
    </head>
    <body>
        <%@ include file="nav-login.html" %> 
        <div class='register-login-form'> 
            <form action="login" method="POST">
                <input type="text" name="username" id="username" placeholder='Username'>
                <input type="password" name="password" id="password" placeholder='Password'>
                <input type="submit" value="LOGIN">
            </form>
            <c:if test="${!empty error}">
                <p class='error'>ERROR: ${error}</p>
            </c:if>
        </div>
    </body>
</html>
