<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#studentTable').DataTable({
            order: [[ 3, 'desc' ]]
        });
    });
</script>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>

    <c:choose>
        <c:when test="${pageContext.request.remoteUser != null}">
            <div class="container textBox">
                <h1 class="mainHeading text-center">Welcome, ${pageContext.request.getRemoteUser()}!</h1>
                <div class="card-deck mt-4 mb-4">
                    <div class="card bg-dark mb-2 indexCard">
                        <div class="card-header indexCardHeader bg-black">
                            <h3 class="card-title subHeading text-center">Current Practice Streak</h3>
                        </div>
                        <div class="card-body">
                            <p class="text-center practiceCounter">${user.practiceCounter}</p>
                        </div>
                        <div class="card-footer text-center bg-black"><h3 class="subHeading">days</h3></div>
                    </div>
                    <div class="card bg-dark mb-2 indexCard">
                        <div class="card-header indexCardHeader bg-black">
                            <h3 class="card-title subHeading text-center">Longest Practice Streak</h3>
                        </div>
                        <div class="card-body text-center">
                            <p class="text-center practiceCounter">${user.longestStreak}</p>
                        </div>
                        <div class="card-footer text-center bg-black"><h3 class="subHeading">days</h3></div>
                    </div>
                </div>
            </div>
            <c:if test="${pageContext.request.isUserInRole('teacher')}">
                <div class="container textBox">
                    <c:forEach var="studio" items="${studios}">
                        <c:if test="${!empty studio.value && studio.value != null}">
                            <h1 class="mainHeading text-center">${studio.key}</h1>
                            <div class="container-fluid text-light">
                                <table id="studentTable" class="display text-center" cellspacing="0" width="100%">
                                    <thead class="bg-black">
                                        <th>Student</th>
                                        <th>Username</th>
                                        <th>Age</th>
                                        <th>Practice Counter</th>
                                        <th>Longest Practice Streak</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="student" items="${studio.value}">
                                            <tr>
                                                <td>${student.firstName} ${student.lastName}</td>
                                                <td>${student.username}</td>
                                                <td>${student.age}</td>
                                                <td>${student.practiceCounter}</td>
                                                <td>${student.longestStreak}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </c:if>
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
