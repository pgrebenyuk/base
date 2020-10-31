<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
</head>

<body>
    <div th:if = "${param.error}">
        Invalid username and password.
    </div>
    <div th:if = "${param.logout}">
        You have been logged out.
    </div>

    <form th:action = "@{/articles}" method = "post">
        <div>
            <label> User Name : <input type = "text" name = "username"/> </label>
        </div>
        <div>
            <label> Password: <input type = "password" name = "password"/> </label>
        </div>
        <div>
            <input type = "submit" value = "Sign In"/>
        </div>
    </form>
</body>
</html>
