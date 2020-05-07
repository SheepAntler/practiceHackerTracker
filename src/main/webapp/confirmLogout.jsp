<%@include file="templates/head.jsp"%>
<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container text-center textBox homepageBox">
        <h1 class="mainHeading indexHeading">Are you sure you're ready to sign off?</h1>
        <div class="row buttonContainer">
            <a class="btn btn-secondary col-4 button" href="logout">Goodbye!</a>
            <a class="btn btn-dark col-4 button" href="index.jsp">No; I'd like to stay.</a>
        </div>
    </div>
</body>
</html>

