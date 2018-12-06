<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06.12.2018
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
           modelAttribute="crmUser"
           method="POST"
           class="form-horizontal">

    <!-- Place for messages: error, alert etc ... -->

    <%--<div class="form-group">--%>
        <%--<div class="col-xs-15">--%>
            <%--<div>--%>

                <%--<c:if test="${param.error!=null}">--%>
                    <%--<div class="alert alert-danger col-xs-offset-1 col-xs-10">--%>
                        <%--Invalid username or password.--%>
                    <%--</div>--%>
                <%--</c:if>--%>

                <%--<c:if test="${param.logout!=null}">--%>
                    <%--<div class="alert alert-success col-xs-offset-1 col-xs-10">--%>
                        <%--You have been logged out.--%>
                    <%--</div>--%>
                <%--</c:if>--%>

            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <!-- User name -->
    <div style="margin-bottom: 25px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <form:input path="user" placeholder="username (*)" class="form-control" />
    </div>

    <!-- Password -->
    <div style="margin-bottom: 25px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
        <form:password path="password" placeholder="password (*)" class="form-control" />
    </div>

    <!-- Confirm Password -->
    <div style="margin-bottom: 25px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

        <form:password path="secondPassword" placeholder="confirm password (*)" class="form-control" />
    </div>


    <!-- First name -->
    <div style="margin-bottom: 25px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <form:input path="name" placeholder="first name (*)" class="form-control" />
    </div>

    <!-- Last name -->
    <div style="margin-bottom: 25px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <form:input path="lastName" placeholder="last name (*)" class="form-control" />
    </div>

    <!-- Email -->
    <div style="margin-bottom: 25px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <form:input path="email" placeholder="email (*)" class="form-control" />
    </div>



    <!-- Register Button -->
    <div style="margin-top: 10px" class="form-group">
        <div class="col-sm-6 controls">
            <button type="submit" class="btn btn-primary">Register</button>
        </div>
    </div>

</form:form>

</body>
</html>
