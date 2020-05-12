<%@include file="templates/head.jsp"%>
<%@taglib uri="http://practiceHacker.com/functions" prefix="f" %>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#practiceLogTable').DataTable({
            order: [[ 0, 'desc' ]]
        });
    });
</script>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Student Logs</h1>
        <hr />
        <form action="viewStudentLogs">
            <h2 class="subHeading">Students</h2>
            <label class="sr-only" for="studentsInStudio">Students</label>
            <select name="studentsInStudio" class="form-control" id="studentsInStudio">
                <option value="" disabled selected>Choose a Student...</option>
                <c:forEach var="studio" items="${studios}">
                    <option value="" class="studioTitleOption" disabled>${studio.key}</option>
                    <c:forEach var="student" items="${studio.value}">
                        <option value="${student.username}">${student.firstName} ${student.lastName}</option>
                    </c:forEach>
                </c:forEach>
            </select>
            <div class="row buttonContainer mt-4">
                <button type="submit" class="btn btn-secondary button smallButton">View Student's Log</button>
            </div>
        </form>
    </div>
    <c:if test="${logAcquired != null}">
        <div class="textBox logBox">
            <h2 class="mainHeading text-center">${studentLog.firstName} ${studentLog.lastName}'s Log</h2>
            <hr />
            <c:choose>
                <c:when test="${!empty studentLog.practiceLogs}">
                    <div class="container-fluid">
                        <table id="practiceLogTable" class="display text-center" cellspacing="0" width="100%">
                            <thead class="bg-black">
                                <th>Date</th>
                                <th>Duration</th>
                                <th>Activities</th>
                                <th>Notes</th>
                            </thead>
                            <tbody>
                                <c:forEach var="log" items="${studentLog.practiceLogs}">
                                    <tr>
                                        <td>${f:formatLocalDateTime(log.practiceDate, 'MM-dd-yyyy')}</td>
                                        <td>${log.practiceDuration} min</td>
                                        <td>${log.activities}</td>
                                        <td>${log.notes}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <p class="text-center">This student hasn't logged any practice sessions yet.</p>
                </c:otherwise>
            </c:choose>
        </div>
    </c:if>
</body>
</html>
