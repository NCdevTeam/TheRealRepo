<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 26.04.2017
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
    <div>
        <h3>${item.name}</h3>
        <p>${item.description}</p>
        <p>${item.imageUrl}</p>
        <p><a href="/book/author/${item.author.id}">Псмотреть другие книги этого автора.</a></p>
    </div>
    <di>
        <h3>Author info:</h3>
        <p>${item.author.name}</p>
        <p>${item.author.nickName}</p>
        <p>${item.author.lastName}</p>
    </di>
<%@include file="includes/commentSection.jsp"%>
</body>
</html>
