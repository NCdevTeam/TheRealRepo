<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authorize access="isAuthenticated()">
    <div class="block__com">
        <h3>Add comment</h3>
        <div class="block__com__av"></div>
        <form:form method="post" modelAttribute="newComment" action="/comments/add">
            <textarea name="commentText" id="" cols="30" rows="10" placeholder="Leave comment" ></textarea>
            <input type="hidden" name="noteId" value="${item.id}"/>
            <input type="hidden" name="noteType" value="${noteType}"/>
            <button type="submit">Send</button>
        </form:form>
    </div>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <h3>Login to leave a comment</h3>
</sec:authorize>
<div class="read__com">
<c:forEach items="${commentList}" var="comment">
    <div class="block__com__av"></div>
    <ul class="com__ndt">
        <li class=com__name><a href="/user/${comment.user.username}">${comment.user.username}</a></li>
        <li class="com__date">${comment.dateTime}</li>
        <%--<li class="com__time">8:01</li>--%>
    </ul>
    <div class="block__com__read">
        <p>${comment.commentText}</p>
    </div>
</c:forEach>
</div>
