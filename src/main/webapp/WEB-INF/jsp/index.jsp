<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 01.04.2017
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@include file="includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="index_head">
    <h1>Welcome stranger. Haven't seen you in a while.</h1>
    <div style="display:table">
        <div class="table_cell">
            <h2><a href="/book">Take a look at our books</a></h2>
        </div>
        <div class="table_cell">
            <h2>or</h2>
        </div>
        <div class="table_cell">
            <h2><a href="/author">Our authors</a></h2>
        </div>
    </div>
</div>
    <content>
        <div class="content">
            <c:forEach items="${item}" var="advert">
                <div class="block__nt">
                        <%--<div class="block__ad_name">${advert.advertName}</div>--%>
                    <div class="block__name">${advert.book.name}</div>
                    <div class="block__img">
                        <img src="${advert.book.imageURL}" width="280" height="200" alt="">
                    </div>
                    <div class="block__go">
                        <span class="price">${advert.price} $</span>
                        <a href="/advert/${advert.id}"><button class="go__button">Go</button></a>
                    </div>
                </div>
            </c:forEach>
            <div class="numbers">
                <%--<ul>--%>
                    <%--<li><a href="#">СЛЕДУЮЩАЯ СТРАНИЦА</a></li>--%>
                    <%--<li><a href="#">1</a></li>--%>
                    <%--<li><a href="#">2</a></li>--%>
                    <%--<li><a href="#">3</a></li>--%>
                    <%--<li><a href="#">4</a></li>--%>
                    <%--<li><a href="#">5</a></li>--%>
                    <%--<li><a href="#">6</a></li>--%>
                    <%--<li><a href="#">7</a></li>--%>
                    <%--<li><a href="#">НАЗАД</a></li>--%>
                <%--</ul>--%>
            </div>
        </div>
    </content>
<%@include file="includes/footer.jsp"%>