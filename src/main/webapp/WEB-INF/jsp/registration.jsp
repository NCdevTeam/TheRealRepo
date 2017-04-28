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
<html>
<head>
    <title>Регистрация</title>
    <spring:url value="/resources/style.css" var="regCss"/>
    <link href="${regCss}" rel="stylesheet"/>
</head>
<body>
<div class="wrapper">
    <span class="name">Регистрация</span>
    <form:form method="post" modelAttribute="newUser" action="/registration">
        <ul>
            <li><form:input path="username" type="text" id="username" placeholder="Username" /></li>
            <li><form:password path="password" id="password" placeholder="Password"/></li>
            <li><input placeholder="Второй пока не требуется."/> </li>
            <li><form:input path="email" id="email" placeholder="E-mail"/></li>
            <li><button id="subbut" type="submit">Submit</button></li>
        </ul>
    </form:form>
</div>
</body>
</html>
