<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 27.04.2017
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/resources/css/normolize.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <script type="text/javascript" src="/resources/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/resources/searchEngine.js"></script>
</head>
<body>
<div class="wrapper">
    <header>
        <div class="header">
            <div class="header__logo">
                <img src="/resources/img/bg.png" alt="bookvita" width="100px" height="100px">
            </div>
            <nav class="menu">
                <ul class="nav__ul">
                    <li><a id="searchRef" href="#">Найти</a>

                        <ul>
                            <li><input id="searchIn" class="search" type="text" placeholder="Поиск в каталоге..."></li>
                        </ul>

                    </li>
                    <li><a href="/">Главная</a></li>
                    <li><a href="/advert">Объявления</a></li>
                    <%--<li><a href="/book">Книги</a></li>--%>
                    <%--<li><a href="/author">Авторы</a></li>--%>
                    <sec:authorize access="isAnonymous()">
                        <li><a href="/registration">Регистрация</a></li>
                        <li><a href="#">Войти</a>
                            <form action ="/login" method="post">
                                <input style="display:none;" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <ul nav__ul><!--блок входа-------------->
                                    <li>
                                        <div class="block__log">
                                            <input name="username" class="log__inp" type="text" placeholder="Логин">
                                            <input name="password" class="log__inp" type="password" placeholder="Пароль">
                                            <button type="submit" class="log__but">Войти</button>
                                            <div class="log__string"><a href="#">Забыли пароль?</a></div>
                                        </div>
                                    </li>
                                    <li>
                                        <c:if test="${param.error != null}">
                                            <div>
                                                Failed to login.
                                                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                                                    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                                                </c:if>
                                            </div>
                                        </c:if>
                                    </li>
                                </ul><!--------------------------------->
                            </form>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li><a href="#"> мой Профиль</a>
                            <ul class="my__profile">
                                <li class="menu__nickname"><a href="/user/<sec:authentication property="principal.username"/>"><sec:authentication property="principal.username"/></a></li>
                                <li><a href="/library">Мои книги</a></li>
                                <li><a href="/wishes">Мои желания</a></li>
                                <li><a href="/advert/my">Мои объявления</a></li>
                                <li><a href="/dialog">Диалоги</a></li>
                                <li><a href="/logout">Выйти</a></li>
                            </ul>
                        </li>
                    </sec:authorize>
                </ul>
            </nav>
        </div>
    </header>