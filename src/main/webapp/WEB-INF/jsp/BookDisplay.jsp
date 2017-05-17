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
<content>
    <div class="content">

        <div class="open__book">
            <div class="open__img">
                <img src="${item.imageURL}" alt="${item.name}">
            </div>
            <div class="open__inf">
                <ul class="open__list">
                    <li><span class="book_info">${item.name}</span></li>
                    <li><span class="book_info">Author: </span><p><a class="book_info" href="/author/${item.author.id}">${item.author.firstName} ${item.author.lastName}</a></p></li>
                    <li><span class="book_info">Description: </span><p id="book_desc">${item.description}</p></li>
                    <%--<li><span>Издательство: </span></li>--%>
                    <%--<li><span>Год:</span></li>--%>
                    <%--<li><span>Тематика:</span></li>--%>
                    <%--<li><span>Страниц:</span></li>--%>
                    <%--<li><span>Переплёт:</span></li>--%>
                    <%--<li><span>Переводчик:</span></li>--%>
                </ul>
            </div>
            <div class="open__buttons2">
                <sec:authorize access="isAuthenticated()">
                <c:if test="${!hasBought}">
                <c:choose>
                <c:when test="${!hasWish}">
                    <div class="table_cell">
                        <a href="/book/wish/${item.id}"><button>Add to wish list.</button></a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="table_cell">
                    <a href="/book/deleteWish/${item.id}"><button>Delete from wish list.</button></a>
                    </div>
                </c:otherwise>
                </c:choose>
                </c:if>
                </sec:authorize>
                <div class="table_cell">
                <a href="/advert/book/${item.id}"><button>Look for ads with this book.</button></a>
                </div>
            </div>
        </div>

        <%@include file="includes/commentSection.jsp"%>

    </div>
</content>

<%@include file="includes/footer.jsp"%>
