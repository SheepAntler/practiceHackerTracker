<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/9/20
  Time: 2:57 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="teacherHome.jsp">PracticeHacker</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/teacherHome.jsp' ? ' active' : ''}">
                <a class="nav-link" href="teacherHome.jsp">Teacher Home</a>
            </li>
            <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/viewStudentLogs.jsp' ? ' active' : ''}">
                <a class="nav-link" href="viewStudentLogs.jsp">Student Logs</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Practice Hacks
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                    <a class="dropdown-item" href="hackWriter.jsp">Hack Writer</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="viewHacks.jsp">View Hacks</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Practice Logs
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <a class="dropdown-item" href="viewMyLog.jsp">View My Log</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="logWriter.jsp">Log Writer</a>
                </div>
            </li>
            <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/imslpSearch.jsp' ? ' active' : ''}">
                <a class="nav-link" href="imslpSearch.jsp">Music Search</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/viewProfile.jsp' ? ' active' : ''}">
                <a class="nav-link" href="viewProfile">Profile</a>
            </li>
            <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/teacherAdmin.jsp' ? ' active' : ''}">
                <a class="nav-link" href="teacherAdmin.jsp">Admin</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Log Out</a>
            </li>
        </ul>
    </div>
</nav>
