<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 19.04.2017
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registracia</title>
    <link rel="stylesheet" href="/resources/css/normolize.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<div class="wrapper">
    <header>
        <div class="header">
            <div class="header__logo">
                <img src="/resources/img/bg.png" alt="bookvita" width="100px" height="100px">
            </div>
        </div>
        <div class="name__reg"> РЕГИСТРАЦИЯ АККАУНТА BOOKVITA</div>
    </header>

    <content class="content">

        <div>
            <form:form class="rega__list" method="post" action="/registration" modelAttribute="newUser">
                <ul>
                    <li><input type="text" placeholder="Введите логин" name="username"></li>
                    <li><input type="password" placeholder="Введите пароль" name="password"></li>
                    <li><input type="password" placeholder="Повторите пароль"></li>
                    <li><input type="email" placeholder="Введите e-m@il" name="email"></li>
                    <li><input type="number" placeholder="Введите номер телефона" name="phoneNumber"></li>
                    <li class="check__box"><input type="checkbox"><span class="check__box__span">Согласен с обратобкой персональных данных</span></li>
                    <li><button type="submit" class="rega__list__button">ЗАРЕГЕСТРИРОВАТЬ</button></li>
                </ul>
            </form:form>
        </div>
    </content>
    <%@include file="includes/footer.jsp"%>

