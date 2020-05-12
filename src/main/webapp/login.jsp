<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/head.jsp"%>
<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox formBox loginBox">
        <h1 class="mainHeading text-center">Log In</h1>
        <hr />
        <FORM ACTION="j_security_check" METHOD="POST" class="text-center">
            <TABLE class="col-sm-12">
                <TR><TD class="loginTd mb-1 mt-2">Username: <INPUT TYPE="TEXT" NAME="j_username" class="form-control mb-2">
                <TR><TD class="loginTd mb-1 mt-2">Password: <INPUT TYPE="PASSWORD" NAME="j_password" class="form-control mb-2">
                <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In" class="btn btn-dark m-2 button smallButton">
            </TABLE>
        </FORM>
    </div>
</body>
</html>
