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
    <div class="textBox logBox">
        <h1 class="mainHeading text-center">My Logs</h1>
        <hr />

        <c:if test="${successMessage != null}">
            <p class="text-success text-center">${successMessage}</p>
        </c:if>
        <div class="container-fluid">
            <table id="practiceLogTable" class="display" cellspacing="0" width="100%">
                <thead>
                    <th>Date</th>
                    <th>Duration</th>
                    <th>Activities</th>
                    <th>Notes</th>
                </thead>
                <tbody>
                    <c:forEach var="log" items="${user.practiceLogs}">
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
    </div>
</body>
</html>
