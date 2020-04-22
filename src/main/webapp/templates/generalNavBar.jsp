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
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/account.jsp' || '/practiceHackerTracker/account.jsp' ? ' active' : ''}">
                <a class="nav-link" href="account.jsp">Log In</a>
            </li>
            <li class="nav-item ${pageContext.request.requestURI eq '/practiceHackerTracker_war/signUp.jsp' || '/practiceHackerTracker/signUp.jsp' ? ' active' : ''}">
                <a class="nav-link" href="signUp.jsp">Register</a>
            </li>
        </ul>
    </div>
</nav>
