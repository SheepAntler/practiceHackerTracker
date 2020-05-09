<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="index.jsp">Practice{Hacker}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:choose>
                <c:when test="${pageContext.request.getRemoteUser() != null}">
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/index.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="dashboard">Home</a>
                    </li>
                    <c:if test="${pageContext.request.isUserInRole('student')}">
                        <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/studioInfo' ? ' active' : ''}">
                            <a class="nav-link" href="studioInfo">My Studio</a>
                        </li>
                    </c:if>
                    <c:if test="${pageContext.request.isUserInRole('teacher')}">
                        <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/viewStudentLogs.jsp' ? ' active' : ''}">
                            <a class="nav-link" href="viewStudentLogs.jsp">Student Logs</a>
                        </li>
                    </c:if>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Practice Logs
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="viewMyLog.jsp">View My Log</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="logWriter.jsp">Log Writer</a>
                        </div>
                    </li>
                    <c:if test="${pageContext.request.isUserInRole('student') || pageContext.request.isUserInRole('practiceHacker')}">
                        <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/viewPracticeHacks.jsp' ? ' active' : ''}">
                            <a class="nav-link" href="practiceHacks">Practice Hacks</a>
                        </li>
                    </c:if>
                    <c:if test="${pageContext.request.isUserInRole('teacher')}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Practice Hacks
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                                <a class="dropdown-item" href="practiceHackWriter.jsp">Hack Writer</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="viewPracticeHacks.jsp">View Hacks</a>
                            </div>
                        </li>
                    </c:if>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Practice Tools
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                            <a class="dropdown-item" href="youTubeSearch.jsp">YouTube</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="metronome.jsp">Metronome</a>
                        </div>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/index.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/about.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="about.jsp">About Us</a>
                    </li>
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/accountTypes.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="accountTypes.jsp">Account Types</a>
                    </li>
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/faq.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="faq.jsp">FAQ</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
        <ul class="navbar-nav ml-auto">
            <c:choose>
                <c:when test="${pageContext.request.getRemoteUser() != null}">
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/viewProfile.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="profile.jsp">${user.username}'s Profile</a>
                    </li>
                    <c:if test="${pageContext.request.isUserInRole('teacher')}">
                        <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/teacherAdmin.jsp' ? ' active' : ''}">
                            <a class="nav-link" href="teacherAdmin.jsp">Admin</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="confirmLogout.jsp">Log Out</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/account.jsp' || '/practiceHackerTracker/account.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="dashboard">Log In</a>
                    </li>
                    <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/register.jsp' || '/practiceHackerTracker/register.jsp' ? ' active' : ''}">
                        <a class="nav-link" href="register.jsp">Register</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
