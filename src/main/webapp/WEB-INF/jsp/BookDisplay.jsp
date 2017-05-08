<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 26.04.2017
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
    <div>
        <h3>${item.name}</h3>
        <p>${item.description}</p>
        <p>${item.imageUrl}</p>
        <p><a href="/book/author/${item.author.id}">Псмотреть другие книги этого автора.</a></p>
    </div>
    <div>
        <h3>Author info:</h3>
        <p>${item.author.firstName}</p>
        <p>${item.author.nickName}</p>
        <p>${item.author.lastName}</p>
    </div>
    <sec:authorize access="isAuthenticated()">
        <c:if test="${!hasBought}">
            <c:choose>
                <c:when test="${!hasWish}">
                    <div>
                        <a href="/book/wish/${item.id}">I wish this book was MINE!</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div>
                        <p>In ur wish pool</p>
                        <a href="/book/deleteWish/${item.id}">Delete from my wish list... meh..</a>
                    </div>
                </c:otherwise>
            </c:choose>
            <div>
                <a href="http://google.com">Find ad with this book!</a>
            </div>
        </c:if>

    </sec:authorize>
<%@include file="includes/commentSection.jsp"%>
</body>
</html>
