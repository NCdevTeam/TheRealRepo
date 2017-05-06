<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <p>Comment section below</p>
    <table>
        <tr>
            <th>Автор</th>
            <th>Коммент</th>
            <th>Дата и Время</th>
        </tr>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td><a href="/user/${comment.user.username}">${comment.user.username}</a></td>
                <td>${comment.commentText}</td>
                <td>${comment.dateTime}</td>
            </tr>
        </c:forEach>
    </table>
    <sec:authorize access="isAuthenticated()">
        <p> Leave your own comment </p>
        <form:form method="post" modelAttribute="newComment" action="/comments/add">
            <ul>
                <li><form:input path="commentText" type="textarea" id="commentText" placeholder="Leave ur opinion"/></li>
                <li><button id="submit" type="submit">Leave ur shit</button></li>
            </ul>
            <input type="hidden" name="noteId" value="${item.id}"/>
            <input type="hidden" name="noteType" value="${noteType}"/>
        </form:form>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <p>Login to leave a comment</p>
    </sec:authorize>
</div>