<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Student Logs</h1>
        <form action="viewStudentLogs">
            <h2 class="subHeading">Students</h2>
            <label class="sr-only" for="studentsInStudio">Students</label>
            <select name="studentsInStudio" class="form-control" id="studentsInStudio">
                <option value="" disabled selected>Choose a Student...</option>
                <c:forEach var="studio" items="${studios}">
                    <option value="" disabled>${studio.key}</option>
                    <c:forEach var="student" items="${studio.value}">
                        <option value="${student.username}">${student.firstName} ${student.lastName}</option>
                    </c:forEach>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-secondary">View Student's Log</button>
        </form>
    </div>
    <c:if test="${logAcquired != null}">
        <div class="container textBox">
            <h2 class="subHeading">${studentLog.firstName} ${studentLog.lastName}'s Log</h2>
            <c:forEach var="log" items="${studentLog.practiceLogs}">
                <p>${log.practiceDate}</p>
                <p>Calculated Duration</p>
                <p>${log.activities}</p>
                <p>${log.notes}</p>
                <%-- TODO generate a column that links to comments form IF the comments field is null --%>
            </c:forEach>
    </c:if>
    <c:remove var="logAcquired" scope="session" />
    </div>
</body>
</html>
