<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 26.04.2017
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<body>
<h2>All Books By author ${tempBook.get(0).authorID}</h2>

<table border="1">
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Book description Name</th>
    </tr>
    <c:forEach items="${tempBook}" var="bk">
        <tr>
            <td>${bk.id}</td>
            <td>${bk.name}</td>
            <td>${bk.description}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>