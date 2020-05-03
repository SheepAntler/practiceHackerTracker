<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Practice Hacks</h1>
        <%--TODO if you're not a teacher, you'll just see hacks for your instrument/skill level--%>
        <c:if test="${pageContext.request.isUserInRole('student') || pageContext.request.isUserInRole('practiceHacker')}">
            <h2 class="subHeading text-center">Tips, Tricks, and Ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
            <c:forEach var="practiceHack" items="${practiceHacks}">
                <p>Author: ${practiceHack.user.firstName} ${practiceHack.user.lastName}</p>
                <p>${practiceHack.practiceHack}</p>
            </c:forEach>
        </c:if>
        <%--TODO if you're a teacher, you get a search form on this page that allows you see any hacks you want--%>
    </div>
</body>
</html>
