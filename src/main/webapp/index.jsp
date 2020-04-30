<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp"%>
<html>
<body>
    <%@include file="templates/navbar.jsp"%>

    <c:choose>
        <c:when test="${pageContext.request.isUserInRole('student') || pageContext.request.isUserInRole('practiceHacker')}">
            <div class="container textBox">
                <h1 class="mainHeading">Welcome Back, ${pageContext.request.getRemoteUser()}!</h1>
                <h2 class="subHeading">You've practiced ${user.practiceCounter} days in a row!</h2>
                <h2 class="subHeading">Your longest streak is ${user.longestStreak} days.</h2>
            </div>
        </c:when>
        <c:when test="${pageContext.request.isUserInRole('teacher')}">
            <div class="container textBox">
                <h1>This will ultimately be the teacher's studio leaderboard!</h1>
            </div>
        </c:when>
        <c:otherwise>
            <div class="container text-center textBox homepageBox">
                <h1 class="mainHeading indexHeading">Practice{Hacker}</h1>
                <div class="row buttonContainer">
                    <a class="btn btn-dark col-4 button" href="dashboard">Log In</a>
                    <a class="btn btn-dark col-4 button" href="register.jsp">Register</a>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</body>
</html>
