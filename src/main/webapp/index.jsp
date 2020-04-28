<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp"%>
<html>
<body>
    <%@include file="templates/generalNavBar.jsp"%>
    <c:if test="${pageContext.request.getRemoteUser() == null}">
        <div class="container text-center textBox homepageBox">
            <h1 class="mainHeading indexHeading">Practice{Hacker}</h1>
            <div class="row buttonContainer">
                <a class="btn btn-dark col-4 button" href="login">Log In</a>
                <a class="btn btn-dark col-4 button" href="account.jsp">Register</a>
            </div>
        </div>
    </c:if>
    <c:if test="${pageContext.request.getRemoteUser() != null}">
        <h1>Welcome Back, ${pageContext.request.getRemoteUser()}!</h1>
    </c:if>
</body>
</html>
