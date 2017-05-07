<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 07.05.2017
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div>
    <table>
        <c:forEach items="${item}" var="link">
            <tr>
                <td><a href="/book/${link.book.id}">${link.book.name}</a></td>
                <td><a href="/book/author/${link.book.author.id}">${link.book.author.nickName}</a></td>
                <c:if test="${link.type == 'wish'}">
                    <td><a href="/book/deleteWish/${link.book.id}">Удалить из пожеланий</a></td>
                    <td><a href="http://google.com">Найти книгу</a></td>
                </c:if>
                <c:if test="${link.type == 'pool'}">
                    <td><a href="http://avito.ru">Создать объявление на основе этой книги!</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>