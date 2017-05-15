<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 07.05.2017
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${item.size() != 0}">
    <c:if test="${item.get(0).type == 'wish'}">
        <h1>Let's look what's in your wishlist.</h1>
    </c:if>
    <c:if test="${item.get(0).type == 'pool'}">
        <h1>That's all your books in system.</h1>
        <h3>Haven't find book in our system? <a href="#">Add it now!</a></h3>
    </c:if>
</c:if>
<c:if test="${item.size() == 0}">
    <h1>Your list is empty.. add something!</h1>
    <h3>Haven't find book in our system? <a href="#">Add it now!</a></h3>
</c:if>
<content>
    <div class="content">
        <div class="bibli__block">
            <ul class="bibl__list">
                <c:forEach items="${item}" var="link">
                    <li>
                        <div class="box__book">
                            <div class="bibl__img">
                                <img src="${link.book.imageURL}" alt="${link.book.name}">
                            </div>
                            <div class="bibl__name"><p>${link.book.name}</p></div>
                            <div class="bibl__author">${link.book.author.firstName} ${link.book.author.lastName}</div>
                            <a href="/book/${link.book.id}"><button class="bibl__but">Подробнее</button></a>
                        </div>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </div>
</content>
<%@include file="includes/footer.jsp"%>
