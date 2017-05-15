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
<div id="bookCreationDiv" class="create__info">
    <ul>
        <p>Author: </p><select name="authorId" id="selectAuthor">
            <option value="0" selected="selected">Select author:</option>
            <c:forEach items="${authorList}" var="author">
                <option value="${author.id}">${author.firstName} ${author.lastName}</option>
            </c:forEach>
        </select>

        <li><p>Require new author:</p></li>
        <li><input type="checkbox" name="requireNewAuthor" value="${requireNewAuthor}" id="requireNewAuthorBox"/></li>
        <li><input placeholder="Book name" type="text" name="name"/></li>
        <li><textarea class="create__text" placeholder="Book description" name="description"></textarea></li>
        <li><input placeholder="Cover url" type="text" name="imageURL"/></li>
    </ul>
</div>