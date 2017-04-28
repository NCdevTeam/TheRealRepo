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

<html>
<head>
    <title>${title}</title>
    <div style="width:100%;height: 33px;background: #8379cc;padding:5px;border: solid 3px #404256;">
        <a href="/" style="color: #acffb5;margin-right: 15px;">На глагнэ</a>
        <sec:authorize access="isAuthenticated()">
            Вы вошли как: <sec:authentication property="principal.username"/>
            <a href="logout" style="color: #acffb5;margin-left: 15px;">Выйти</a>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            Пожалуйста,
            <a href="login" style="color: #acffb5;">войдите</a>
            или
            <a href="registration" style="color: #acffb5;">зарегистрируйтесь.</a>
        </sec:authorize>
    </div>
</head>
