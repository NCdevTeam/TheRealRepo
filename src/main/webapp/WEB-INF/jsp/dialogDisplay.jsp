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
<%request.setCharacterEncoding("UTF-8");%>
<body>
<div>
    <table>
        <tr>
            <td>Кто</td>
            <td>Что</td>
            <td>Когда</td>
        </tr>
        <c:forEach items="${item}" var="msg" >
            <tr>
                <td>${msg.sender.username}</td>
                <td>${msg.text}</td>
                <td>${msg.msgDateTime}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    Send new message:
    <sec:authorize access="isAuthenticated()">
        <form:form method="post" modelAttribute="newMessage" action="/dialog/${receiver.username}/send">
            <form:input path="text" type="textarea" id="msgText" placeholder="enter message..."/>
            <button type="submit">Send</button>
        </form:form>
    </sec:authorize>
</div>
</body>
</html>
