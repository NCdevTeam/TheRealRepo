<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 05.05.2017
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>

<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%response.setCharacterEncoding("UTF-8");%>
<content>
    <div class="content">
        <div class="block__chat">
            <div class="box__nav">
                <button class="button__back">Назад</button>
                <a href="/user/${receiver.username}"><div class="user__name">${receiver.username}</div></a>
            </div>
            <div class="box__chat">
                <c:forEach items="${item}" var="msg">
                    <p><${msg.msgDateTime}> ${msg.sender.username}: ${msg.text}</p>
                </c:forEach>
            </div>
            <form:form action="/dialog/${receiver.username}/send" class="box__buttons" method="post">
                <input name="text" class="input__mess" type="text">
                <button type="submit" class="button__go">Отправить</button>
            </form:form>
        </div>
    </div>
</content>
<%@include file="includes/footer.jsp"%>