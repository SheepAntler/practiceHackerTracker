<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/9/20
  Time: 1:25 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="index.jsp">Practice{Hacker}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="aboutTracking.jsp">About Practice Tracking</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="aboutHacks.jsp">About Practice Hacks</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Account Types
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="teacherAccounts.jsp">Teacher</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="studentAccounts.jsp">Student</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="practiceHackerAccounts.jsp">Practice Hacker</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="faq.jsp">FAQ</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="account.jsp">Log In</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="signUp.jsp">Sign Up</a>
            </li>
        </ul>
    </div>
</nav>
