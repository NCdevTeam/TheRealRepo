<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 25.04.2017
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>${pageHeader}</h2>

<table border="1">
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Book description Name</th>
        <th>Book author</th>
    </tr>
    <c:forEach items="${tempBook}" var="bk">
        <tr>
            <td>${bk.id}</td>
            <td><a href="/book/${bk.id}">${bk.name}</a></td>
            <td>${bk.description}</td>
            <td>${bk.author.nickName}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>