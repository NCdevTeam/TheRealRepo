<%--
  Created by IntelliJ IDEA.
  User: dR3wD
  Date: 08.05.2017
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<link href="/resources/authorCreationDiv.css" rel="stylesheet"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="authorCreationDiv" class="create__info">
    <ul>
        <p>Enter author information:</p>
        <li><input type="text" name="firstName" placeholder="Author name"/></li>
        <li><input type="text" name="lastName" placeholder="Author surname"/></li>
        <li><input type="text" name="nickName" placeholder="Nickname"/></li>
        <li><textarea class="create__text" type="text" name="authorDescription" placeholder="Short description"></textarea></li>
        <li><input placeholder="Photo url" type="text" name="photoURL"/></li>
    </ul>
</div>
