<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 06.05.2017
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div>
    <table>
        <c:forEach items="${item}" var="usr">
            <tr>
                <td><a href="/dialog/${usr.username}">${usr.username}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
