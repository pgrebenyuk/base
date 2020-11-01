<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
ця штука говорить що ти в html додає теги jstl/core
і щоб до них достукуватись будеш використовувати префікс c
(того що можуть в різних бібліотеках бути оданакові теги)
можеш його поміняти на th і тоді твій код також заробить)
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
</head>

<body>

<%--
ти тут почав використовувати thymeleaf, а в тебе jsp
ти десь скопіював, але теги інші і того нічого не виходить і воно всеодно показує,
що пароль неправильний і що ти вилогінився
поміняй на це що нижче і заробить
тут вже jsp теги

<c:if test="${param.error}">
    <div>Invalid username and password.</div>
</c:if>
<c:if test="${param.logout}">
    <div>You have been logged out.</div>
</c:if>
--%>

<div th:if = "${param.error}">
    Invalid username and password.
</div>
<div th:if = "${param.logout}">
    You have been logged out.
</div>

<%--
так само тут використовуєш thymeleaf th:action
а треба c:action
по великому рахунку ця штука ні на що не впливає, можеш поміняти тут значення на що хоч(англійською)
чи видалити action взагалі і ти побач, що після логіну всеодно попадеш на /articles
того що в налаштуванні Security конфіга є ця стрічка .defaultSuccessUrl("/articles", true)
вона і рішає куди перейде після логіну
--%>
<form th:action = "@{/rst}" method = "post">
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
