<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 24.04.2017
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div>
    <h2>Advert author</h2>
    <h3><a href="/user/${item.user.username}">${item.user.username}</a></h3>
    <h4>${item.user.email}</h4>
    <h4>${item.user.phoneNumber}</h4>
</div>
<div>
    <h2>Advert info:</h2>
    <h4>Description:</h4>
    <p>${item.advertDescription}</p>
    <h4>Book</h4>
    <p>Author: <a href="/author/${item.book.author.id}">${item.book.author.firstName} ${item.book.author.lastName}</a></p>
    <p>Name: <a href="/book/${item.book.id}">${item.book.name}</a></p>
    <p>Description: ${item.book.description}</p>
</div>
<%@include file="includes/commentSection.jsp"%>
</body>
</html>
