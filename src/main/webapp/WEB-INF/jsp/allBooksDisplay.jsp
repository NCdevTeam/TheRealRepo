<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 25.04.2017
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Spring MVC Hello World</title>
</head>

<body>
<h2>All Books in System</h2>

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