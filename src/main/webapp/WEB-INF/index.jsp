<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Здравствуйте!</title>
</head>
<body>
    <div>привіт</div>
    <h1 th:inline = "text">Hello [[${#httpServletRequest.remoteUser}]]!</h1>
    <form th:action = "@{/logout}" method = "post">
        <input type = "submit" value = "Sign Out"/>
    </form>
</body>
</html>
