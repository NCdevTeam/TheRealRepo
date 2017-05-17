<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 25.04.2017
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<content>
    <div class="content">
        <h1>${pageHeader}</h1>
        <c:forEach items="${tempBook}" var="book">
            <div class="my__book">
                <div class="my__book__img">
                    <img src="${book.imageURL}" width="200px" height="200px" alt="${book.name}">
                </div>
                <div class="my__book__list">
                    <ul>
                        <li class="book__name"><a href="/book/${book.id}"> ${book.name}</a></li>
                        <li class="book__author"><a href="/author/${book.author.id}">${book.author.firstName} ${book.author.lastName}</a></li>
                        <li class="book__text">${book.description}</li>
                    </ul>
                </div>
                <div class="my__block__buttons">
                    <a href="/book/${book.id}"><button class="button__read">Details</button></a>
                </div>
            </div>
        </c:forEach>
    </div>
</content>
<%@include file="includes/footer.jsp"%>