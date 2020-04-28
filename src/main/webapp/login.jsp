<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/9/20
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/head.jsp"%>
<html>
<%--<head>--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox formBox">
        <h1 class="mainHeading">Log In</h1>
        <FORM ACTION="j_security_check" METHOD="POST">
            <TABLE>
                <TR><TD class="loginTd">User name: <INPUT TYPE="TEXT" NAME="j_username" class="form-control">
                <TR><TD class="loginTd">Password: <INPUT TYPE="PASSWORD" NAME="j_password" class="form-control">
                <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In" class="btn btn-dark">
            </TABLE>
        </FORM>
    </div>
</body>
</html>
