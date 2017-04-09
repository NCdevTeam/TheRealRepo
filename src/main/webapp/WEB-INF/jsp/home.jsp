<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 01.04.2017
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>HomePage</title>
    <style type="text/css">
        table, th, td {
            border: 1px solid rgba(47, 60, 229, 0.66);
        }
    </style>
</head>
<body>
<div>
    <h3>Here comes the header!</h3>
</div>
<div>
    <c:if test="${tempBook != null}">
        <table>
            <tr>
                <th>Author</th>
                <th>About Author</th>
                <th>name</th>
                <th>description</th>
                <th>Image</th>
            </tr>
            <%--<c:forEach items="${bookListMessage}" var="bk">--%>
                <tr>
                    <th>${authorOfTempBook.nickName}</th>
                    <th>${authorOfTempBook.description}</th>
                    <th>${tempBook.name}</th>
                    <th>${tempBook.description}</th>
                    <th><img src="${tempBook.imageUrl}" width="160" height="160"></th>
                </tr>
            <%--</c:forEach>--%>
        </table>
    </c:if>
</div>
</body>
</html>
