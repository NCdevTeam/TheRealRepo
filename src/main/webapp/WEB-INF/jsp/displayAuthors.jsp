<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/resources/authorCreation.css" rel="stylesheet"/>
<content>
    <div class="content">
        <div class="author__list">
            <h2>Author list</h2>
                <c:forEach items="${item}" var="author">
                    <div class="block__authors">
                        <div class="authors__img">
                            <img src="${author.photoURL}" alt="${author.firstName}_${author.lastName}">
                        </div>
                        <div class="authors__name">
                            <span>${author.firstName} ${author.lastName}</span>
                        </div>
                        <a href="/author/${author.id}"><button>About</button></a>
                    </div>
                </c:forEach>
        </div>



    </div>
</content>
<%@include file="includes/footer.jsp"%>
