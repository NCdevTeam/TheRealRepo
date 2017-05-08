<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div>
    <h3>${item.firstName} ${item.lastName}</h3>
    <h4>${item.nickName}</h4>
    <p>${item.authorDescription}</p>
    <a href="/book/author/${item.id}">Посмотреть книги этого автора.</a>
</div>
<div>
    <img src="${item.photoURL}">
</div>
<%@include file="includes/commentSection.jsp"%>
</body>
</html>
