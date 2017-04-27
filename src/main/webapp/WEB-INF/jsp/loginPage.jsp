
<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 26.04.2017
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<body>
    <c:url value="/log" var="LoginProcessingUrl" />
<form action ="${loginProcessingUrl}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <fieldset>
        <legend> Please LogIn</legend>
        <c:if test="${param.error != null}">
            <div>
                Failed to login.
                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                </c:if>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div>
                You have been logged out
            </div>
        </c:if>
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username" />
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <p>
            <label for="remember-me">Remember me?</label>
            <input type="checkbox" id="remember-me" name="remember-me"/>
        </p>
        <div>
            <button type="submit" class="btn">Log in</button>
        </div>
    </fieldset>
</form>
</body>
</html>