<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/9/20
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="studentHome.jsp">PracticeHacker</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="studentHome.jsp">Student Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Practice Logs
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                    <a class="dropdown-item" href="viewMyLog.jsp">View My Log</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="logWriter.jsp">Log Writer</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    My Studios
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <a class="dropdown-item" href="studioInfo.jsp">My Studio Info</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="studioSearch.jsp">Join a Studio</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="viewHacks.jsp">Practice Hacks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="imslpSearch.jsp">Music Search</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="profile.jsp">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Log Out</a>
            </li>
        </ul>
    </div>
</nav>
