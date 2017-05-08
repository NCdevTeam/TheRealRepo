<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/resources/authorCreation.css" rel="stylesheet"/>
<body>
<div>
    <table>
        <tr>
            <th>Имя</th>
            <th>Псевданим</th>
            <th>Фамилия</th>
            <th>Страница автора</th>
            <th>Произведения</th>
            <th>Фото</th>
        </tr>
        <c:forEach items="${item}" var="author">
            <tr>
                <td>${author.firstName}</td>
                <td>${author.nickName}</td>
                <td>${author.lastName}</td>
                <td><a href="/author/${author.id}">Страница автора</a></td>
                <td><a href="/book/author/${author.id}">Книги автора</a></td>
                <td><img id="AuthorPhoto" src="${author.photoURL}"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
