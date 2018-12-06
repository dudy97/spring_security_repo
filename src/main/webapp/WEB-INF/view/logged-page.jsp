<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.11.2018
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Security App</title>
</head>
<body>
<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br>
    Role: <security:authentication property="principal.authorities"/>

</p>
<hr>
<security:authorize access="hasRole('ASISTANT')">
<hr>
<p>
    <a href="${pageContext.request.contextPath}/assistants">For ASISTANTS</a>
</p>
<hr>
</security:authorize>
Hello!<br>
You are logged user.
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>

</body>
</html>
