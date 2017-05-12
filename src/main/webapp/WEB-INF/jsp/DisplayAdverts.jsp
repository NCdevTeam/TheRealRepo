<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<content>
    <a href="/advert/create"><button class="create__note">Создать объявление</button></a>
    <div class="content">
        <h3>${pageHeader}</h3>
        <c:forEach items="${item}" var="advert">
            <div class="block__nt">
                <%--<div class="block__ad_name">${advert.advertName}</div>--%>
                <div class="block__name">${advert.book.name}</div>
                <div class="block__img">
                    <img src="${advert.book.imageUrl}" width="280" height="200" alt="">
                </div>
                <div class="block__go">
                    <span class="price">${advert.price} рублей</span>
                    <a href="/advert/${advert.id}"><button class="go__button">ПЕРЕЙТИ</button></a>
                </div>
            </div>
        </c:forEach>
        <div class="numbers">
            <ul>
                <li><a href="#">СЛЕДУЮЩАЯ СТРАНИЦА</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">6</a></li>
                <li><a href="#">7</a></li>
                <li><a href="#">НАЗАД</a></li>
            </ul>
        </div>
    </div>
</content>
<%@include file="includes/footer.jsp"%>