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
        <h3>${tempBook.name}</h3>
        <p>${tempBook.description}</p>
        <p>${tempBook.imageUrl}</p>
        <p><a href="/books/author/${tempBook.author.id}">Псмотреть другие книги этого автора.</a></p>
    </div>
    <di>
        <h3>Author info:</h3>
        <p>${tempBook.author.name}</p>
        <p>${tempBook.author.nickName}</p>
        <p>${tempBook.author.lastName}</p>
    </di>
</body>
</html>
