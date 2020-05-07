<%@include file="templates/head.jsp"%>
<%@taglib uri="http://practiceHacker.com/functions" prefix="f" %>
<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">My Logs</h1>

        <c:forEach var="log" items="${user.practiceLogs}">
            <p>${f:formatLocalDateTime(log.practiceDate, 'dd-MM-yyyy')}</p>
            <p>${log.practiceDuration} minutes</p>
            <p>${log.activities}</p>
            <p>${log.notes}</p>
        </c:forEach>
    </div>
</body>
</html>
