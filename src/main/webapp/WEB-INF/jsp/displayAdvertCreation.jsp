<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/adCreationsJs.js"></script>
<body>
<div>
    <form:form method="post" modelAttribute="newAdvert" action="/advert/create">
        <form:input path="advertName" type="textarea" placeholder="Название объявления"/>
        <p>Тип объявления</p><select name="type" id="typeSelection">
            <option selected="selected" value="sell">Продажа</option>
            <option value="exchange">Обмен</option>
            <option value="buy">Покупка</option>
        </select></
        <p>Книга: </p><select name="bookId" id="selectBook">
            <option value="0" selected="selected">Выберите книгу из списка:</option>
            <c:forEach items="${bookList}" var="book">
                <option value="${book.id}">${book.name}</option>
            </c:forEach>
        </select>
        <br>
        <form:input path="advertDescription" type="textarea" placeholder="Добавьте описание объявления."/>
        <br>
        <form:input id="priceInput" path="price" type="number" placeholder="Сумма."/>
        <p>Требуется новая книга:</p>
        <input id="requireNewBookBox" type="checkbox" name="requireNewBook" value="${requireNewBook}"/>
        <%@include file="includes/bookCreationDiv.jsp"%>
        <button type="submit">Подтвердить</button>
    </form:form>
</div>
</body>
</html>
