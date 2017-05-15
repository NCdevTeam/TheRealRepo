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
<content>
    <div id="trueCont" class="content">
<div class="create__note__block">
    <h1>Create advert</h1>
    <div class="create__info">
        <form:form method="post" modelAttribute="newAdvert" action="/advert/create">
            <ul>
                <li><form:input path="advertName" type="textarea" placeholder="Advert name"/></li>
                <p>Advert type: </p><select name="type" id="typeSelection">
                    <option selected="selected" value="sell">Sell</option>
                    <option value="exchange">Exchange</option>
                    <option value="buy">Buy</option>
                </select>
                <p>Книга: </p><select name="bookId" id="selectBook">
                    <option value="0" selected="selected">Select book: </option>
                    <c:forEach items="${bookList}" var="book">
                        <option value="${book.id}">${book.name}</option>
                    </c:forEach>
                </select>
                <li><textarea class="create__text" name="advertDescription" type="textarea" placeholder="Add advert description"></textarea></li>
                <li><form:input id="priceInput" path="price" type="number" placeholder="Сумма."/></li>

                <li><p>Require new book: </p></li>
                <li><input id="requireNewBookBox" type="checkbox" name="requireNewBook" value="${requireNewBook}"/></li>
                <div style="display:table">
                    <div style="display:table-cell">
                        <%@include file="includes/authorCreationDiv.jsp"%>
                    </div>
                    <div style="display:table-cell">
                        <%@include file="includes/bookCreationDiv.jsp"%>
                    </div >
                    <div style="display:table-cell">
                        <button type="submit" class="create__box__bottons">Submit</button>
                    </div>
                </div>

            </ul>
        </form:form>
    </div>
</div>
    </div>
</content>
<%@include file="includes/footer.jsp"%>