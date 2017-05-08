<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<link href="/resources/bookCreationDiv.css" rel="stylesheet"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="bookCreationDiv">
    <p>Автор: </p><select name="authorId" id="selectAuthor">
        <option value="0" selected="selected">Выберите автора из списка:</option>
        <c:forEach items="${authorList}" var="author">
            <option value="${author.id}">${author.firstName} ${author.lastName}</option>
        </c:forEach>
    </select>
    <p>Требуется новый автор:</p>
    <input type="checkbox" name="requireNewAuthor" value="${requireNewAuthor}" id="requireNewAuthorBox"/>
    <%@include file="authorCreationDiv.jsp"%>
    <p>Имя книги</p>
    <input type="text" name="name"/>
    <p>Описание книги</p>
    <input type="text" name="description"/>
    <p>Адрес обложки</p>
    <input type="text" name="imageURL"/>
</div>