<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 24.04.2017
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>${item.advertName}</h3>
    <p>${item.advertDescription}</p>
    <p>${item.status}</p>
</div>
    <p><a href="/book/${item.book.id}">Перейти на страницу книги.</a></p>
</div>
<div>
    <h3>Ad info:</h3>
    <p>${item.user.username}</p>
</div>
</body>
</html>
