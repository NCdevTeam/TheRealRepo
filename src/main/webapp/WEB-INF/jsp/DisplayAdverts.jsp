<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div>
    <a href="/advert/create">Создать новое объявление</a>
    <br>
    <br>
    <table>
        <th></th>
        <c:forEach items="${item}" var="advert">
            <tr>
                <td><a href="/advert/${advert.id}">${advert.advertName}</a></td>
                <td>${advert.type}</td>
                <td>${advert.book.author.firstName}</td>
                <td>${advert.book.author.lastName}</td>
                <td>${advert.book.name}</td>
                <td>${advert.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
