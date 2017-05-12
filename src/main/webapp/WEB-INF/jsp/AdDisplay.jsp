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
            <img src="${item.book.imageUrl}" width="350px" height="350px;" alt="">
        </div>
        <div class="book__inf">
            <ul>
                <li class="open__book__name"><span>Название: </span>${item.advertName}</li>

                <li><span>Название книги: </span><a href="/book/${item.book.id}">${item.book.name}</a></li>

                <li class="open__author__book"><span>Автор: </span>${item.book.author.firstName} ${item.book.author.lastName}</li>

                <li class="open__text__book"><p><span>Описание: </span>${item.advertDescription}</p></li>

                <li class="open__book__izd"><span>Издательство:</span> </li>
                <li сlass="open__book__per"><span>Переплёт: </span> </li>
                <li class="open__book__tem"><span>Тематика: </span>   </li>
                <li сlass="open__book__year"><span>Год: </span> </li>
                <li сlass="open__book__page"><span>Страниц: </span> </li>
            </ul>
            <div class="open__buttons">
                <button class="open__but1">Назад</button>
                <button class="open__but2">Купить</button>
            </div>
        </div>

        <div class="open__user__inf">
            <h7>Владелец обьяления:</h7>
            <h7 class="open__user__nick"><a href="/user/${item.user.username}">${item.user.username}</a></h7>
            <p></p>
            <a href="/dialog/${item.user.username}"><button class="open__button">Связаться</button></a>
            <div class="open__price">
                <p>Цена книги:</p>
                <div class="open__price2">
                    <span>${item.price}p</span>
                </div>
            </div>
        </div>
    </div>
</content>
<%@include file="includes/commentSection.jsp"%>
<%@include file="includes/footer.jsp"%>