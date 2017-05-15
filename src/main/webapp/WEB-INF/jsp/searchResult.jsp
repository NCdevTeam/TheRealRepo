<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 12.05.2017
  Time: 6:03
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<content>
    <div class="content">
        <c:if test="${advertList.size() !=0}">
            <h1>${AdvertHeader}</h1>
            <c:forEach items="${advertList}" var="advert">
                <div class="block__nt">
                        <%--<div class="block__ad_name">${advert.advertName}</div>--%>
                    <div class="block__name">${advert.book.name}</div>
                    <div class="block__img">
                        <img src="${advert.book.imageURL}" width="280" height="200" alt="">
                    </div>
                    <div class="block__go">
                        <span class="price">${advert.price} $</span>
                        <a href="/advert/${advert.id}"><button class="go__button">Go</button></a>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${bookList.size() != 0}">
            <h1>${BookHeader}</h1>
            <c:forEach items="${bookList}" var="book">
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
                        <a href="/book/${book.id}"><button class="button__read">Больше.</button></a>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</content>
<%@include file="includes/footer.jsp"%>
