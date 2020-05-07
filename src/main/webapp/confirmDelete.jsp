<%@include file="templates/head.jsp"%>
<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container text-center textBox homepageBox">
        <h1 class="mainHeading indexHeading text-danger">Are you certain you want to leave? This action cannot be undone.</h1>
        <div class="row buttonContainer">
            <a class="btn btn-danger col-4 button" href="deleteAccount">Confirm</a>
            <a class="btn btn-dark col-4 button" href="profile.jsp">No; I'd like to stay</a>
        </div>
    </div>
</body>
</html>

