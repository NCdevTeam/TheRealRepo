<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<content>
    <div class="content">

        <div class="inf__author__img">
            <img src="${item.photoURL}" alt="">
        </div>

        <div class="list__author__inf">
            <ul class="author__inf__list">
                <li><span>${item.firstName} ${item.lastName}</span></li>
                <li><span>Nickname: </span>Shmele</li>
                <li><span>Birthday: </span>Someday.</li>
                <li><span>City: </span>Berlin</li>
                <li><span>Language: <span>Берлинский</li>
                <li><span>Ganre: </span>В берлинском</li>
                <li><span>${item.authorDescription}</span></li>
            </ul>
        </div>

        <div class="list__author__books">
            <h2>Bibliography</h2>
            <ul>
                <li><a href="/book/author/${item.id}">Show author books</a></li>
            </ul>
        </div>

        <%@include file="includes/commentSection.jsp"%>
    </div>

</content>

<%@include file="includes/footer.jsp"%>