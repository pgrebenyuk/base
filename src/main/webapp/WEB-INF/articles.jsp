<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Articles</title>
</head>

<body>
    <c:forEach var="article" items="${articlesAll}">
        <div>id: ${article.id}</div>
        <div>name: ${article.name}</div>
        <div>price: ${article.price}</div>
        <div>manufacturerId: ${article.manufacturerId}</div>
    </c:forEach>
</body>
</html>
