<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 24.04.2017
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<content>
    <div class="content">
        <div class="book__img">
            <img src="${item.book.imageURL}" width="350px" height="350px;" alt="">
        </div>
        <div class="book__inf">
            <ul>
                <li class="open__book__name"><span>Advert name: </span>${item.advertName}</li>

                <li><span>Book name: </span><a href="/book/${item.book.id}">${item.book.name}</a></li>

                <li class="open__author__book"><span>Author: </span>${item.book.author.firstName} ${item.book.author.lastName}</li>

                <li class="open__text__book"><p><span>Description: </span>${item.advertDescription}</p></li>

                <%--<li class="open__book__izd"><span>Издательство:</span> </li>--%>
                <%--<li сlass="open__book__per"><span>Переплёт: </span> </li>--%>
                <%--<li class="open__book__tem"><span>Тематика: </span>   </li>--%>
                <%--<li сlass="open__book__year"><span>Год: </span> </li>--%>
                <%--<li сlass="open__book__page"><span>Страниц: </span> </li>--%>
            </ul>
            <div class="open__buttons">
                <a href="/advert"><button class="open__but1">Back</button></a>
                <a href="/advert/buy/${item.id}"><button class="open__but2">Buy</button></a>
            </div>
        </div>

        <div class="open__user__inf">
            <h7>User:</h7>
            <h7 class="open__user__nick"><a href="/user/${item.user.username}">${item.user.username}</a></h7>
            <p></p>
            <a href="/dialog/${item.user.username}"><button class="open__button">Contact</button></a>
            <div class="open__price">
                <p>Book price:</p>
                <div class="open__price2">
                    <span>${item.price}$</span>
                </div>
            </div>
        </div>

        <%@include file="includes/commentSection.jsp"%>
    </div>

</content>


<%@include file="includes/footer.jsp"%>