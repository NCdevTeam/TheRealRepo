<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 05.05.2017
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>
<body>
<div>
    <h3>Профиль пользователя ${item.username}</h3>
    <h4>email: ${item.email}</h4>
    <h4>phone number ${item.phoneNumber}</h4>
    <h4>current balance ${item.balance} dorars</h4>
    <a href="/dialog/${item.username}">Диалог с пользователем</a>
</div>
</body>
</html>
