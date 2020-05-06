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
                <c:forEach var="studio" items="${studios}">
                    <c:if test="${!empty studio.value && studio.value != null}">
                        <h1 class="mainHeading text-center">${studio.key}</h1>
                        <c:forEach var="student" items="${studio.value}">
                            <p>${student.firstName} ${student.lastName}: Current Counter = ${student.practiceCounter} & Longest Streak = ${student.longestStreak}</p>
                        </c:forEach>
                    </c:if>
                </c:forEach>
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
