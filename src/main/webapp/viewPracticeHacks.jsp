<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Practice Hacks</h1>
        <%--if you're a practiceHacker you'll just see hacks for your instrument/skill level--%>
        <c:if test="${pageContext.request.isUserInRole('practiceHacker')}">
            <h2 class="subHeading text-center">Tips, Tricks, and Ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
            <c:forEach var="practiceHack" items="${practiceHacks}">
                <p>Author: ${practiceHack.user.firstName} ${practiceHack.user.lastName}</p>
                <p>${practiceHack.practiceHack}</p>
            </c:forEach>
        </c:if>
        <%--TODO if you're a student, you'll be able to see all the hacks for your instrument/skill level OR just the ones your teacher wrote--%>
        <c:if test="${pageContext.request.isUserInRole('student')}">
            <h2 class="subHeading text-center">Tips, Tricks, and Ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
            <form action="practiceHacks">
                <h2 class="subHeading">Please Select the Practice Hacks you'd like to View:</h2>
                <label class="sr-only" for="practiceHackSelector">Please Select the Practice Hacks you'd like to View</label>
                <select name="practiceHackSelector" id="practiceHackSelector">
                    <option value="viewAll">View All</option>
                    <option value="viewTeachersOnly">Just Show Me My Teacher's Practice Hacks</option>
                </select>
                <button type="submit" class="btn btn-secondary">Show Practice Hacks</button>
            </form>
        </c:if>
        <%--TODO if you're a teacher, you get a search form on this page that allows you see practice hacks for you, practice hacks you've written, OR all practice hacks EVER--%>
        <c:if test="${pageContext.request.isUserInRole('teacher')}">
            <form action="practiceHacks">
                <h2 class="subHeading text-center">Please Select the Practice Hacks you'd like to View:</h2>
                <label class="sr-only" for="practiceHackView">Please Select the Practice Hacks you'd like to View</label>
                <select name="practiceHackView" id="practiceHackView">
                    <%-- This output will appear as a jQuery table --%>
                    <option value="allHacks">Show Me All Practice Hacks</option>
                    <%-- The following output will appear as text --%>
                    <option value="authorMode">Show Me Practice Hacks I've Written</option>
                    <option value="practiceMode">Show Me Practice Hacks for my Own Practice</option>
                </select>
            </form>
        </c:if>
    </div>
</body>
</html>
