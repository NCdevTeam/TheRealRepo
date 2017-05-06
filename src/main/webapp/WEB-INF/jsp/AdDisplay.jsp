<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 24.04.2017
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>${tempAd.name}</h3>
    <p>${tempAd.description}</p>
    <p>${tempAd.status}</p>
</div>
    <p><a href="/books/${tempAd.book.id}">Перейти на страницу книги.</a></p>
</div>
<div>
    <h3>Ad info:</h3>
    <p>${tempAd.user.username}</p>
</div>
</body>
</html>
