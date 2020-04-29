<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp"%>
<html>
<body>
    <%@include file="templates/navbar.jsp"%>
<%--    <c:choose>--%>
<%--        <c:when test="${pageContext.request.isUserInRole('student')} && ${pageContext.request.isUserInRole('practiceHacker')}">--%>
<%--            <h1>Welcome Back, ${pageContext.request.getRemoteUser()}!</h1>--%>
<%--            <p>You've practiced ${user.practiceCounter} days in a row!</p>--%>
<%--            <p>Your longest streak is ${user.longestStreak} days.</p>--%>
<%--        </c:when>--%>
<%--        <c:when test="${pageContext.request.isUserInRole('teacher')}">--%>
<%--            <h1>This will ultimately be the teacher's studio leaderboard!</h1>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <div class="container text-center textBox homepageBox">--%>
<%--                <h1 class="mainHeading indexHeading">Practice{Hacker}</h1>--%>
<%--                <div class="row buttonContainer">--%>
<%--                    <a class="btn btn-dark col-4 button" href="login">Log In</a>--%>
<%--                    <a class="btn btn-dark col-4 button" href="register.jsp">Register</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
    <c:if test="${pageContext.request.getRemoteUser() == null}">
        <div class="container text-center textBox homepageBox">
            <h1 class="mainHeading indexHeading">Practice{Hacker}</h1>
            <div class="row buttonContainer">
                <a class="btn btn-dark col-4 button" href="login">Log In</a>
                <a class="btn btn-dark col-4 button" href="register.jsp">Register</a>
            </div>
        </div>
    </c:if>
    <c:if test="${pageContext.request.getRemoteUser() != null}">
        <h1>Welcome Back, ${pageContext.request.getRemoteUser()}!</h1>
        <p>You've practiced ${user.practiceCounter} days in a row!</p>
        <p>Your longest streak is ${user.longestStreak} days.</p>
    </c:if>
</body>
</html>
