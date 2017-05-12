<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 06.05.2017
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<content>
    <div class="content">
        <div class="block__chat">
            <c:forEach items="${item}" var="dialog">
                <a href="/dialog/${dialog.username}">
                    <div class="chat__line">
                        <div class="chat__text">
                            <div class="user__name">
                                ${dialog.username}
                            </div>
                            <div class="chat__mess">
                                Последнее сообщение
                            </div>
                        </div>
                        <div class="user__color"><!--Рандомный цвет-->
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</content>
<%@include file="includes/footer.jsp"%>