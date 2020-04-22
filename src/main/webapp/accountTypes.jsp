<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/generalNavBar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Account Types</h1>
        <h2 class="text-center">whether you're a teacher, student, or seasoned pro, we've got you covered</h2>

        <p class="text-center">All three of our available account types have similar functionality, but it differs just enough to count.
        Check out what we've got, and find the best fit for you.</p>

        <div class="accordion" id="accountTypes">
            <div class="card bg-dark text-light">
                <div class="card-header" id="forTeachers">
                    <h2 class="mb-0">
                        <button class="btn btn-link accordionLink" type="button" data-toggle="collapse" data-target="#teacherInfo" aria-expanded="true" aria-controls="teacherInfo">
                            For Teachers
                        </button>
                    </h2>
                </div>
                <div id="teacherInfo" class="collapse show" aria-labelledby="forTeachers" data-parent="#accountTypes">
                    <div class="card-body">
                        <p>//TODO add a brief description</p>
                        <p>//TODO add a table listing teacher features</p>
                    </div>
                </div>
            </div>
            <div class="card bg-dark text-light">
                <div class="card-header" id="forStudents">
                    <h2 class="mb-0">
                        <button class="btn btn-link collapsed accordionLink" type="button" data-toggle="collapse" data-target="#studentInfo" aria-expanded="false" aria-controls="studentInfo">
                            For Students
                        </button>
                    </h2>
                </div>
                <div id="studentInfo" class="collapse" aria-labelledby="forStudents" data-parent="#accountTypes">
                    <div class="card-body">
                        <p>//TODO add a brief description</p>
                        <p>//TODO add a table listing student features</p>
                    </div>
                </div>
            </div>
            <div class="card bg-dark text-light">
                <div class="card-header" id="forOthers">
                    <h2 class="mb-0">
                        <button class="btn btn-link collapsed accordionLink" type="button" data-toggle="collapse" data-target="#otherInfo" aria-expanded="false" aria-controls="otherInfo">
                            For Everyone Else
                        </button>
                    </h2>
                </div>
                <div id="otherInfo" class="collapse" aria-labelledby="forOthers" data-parent="#accountTypes">
                    <div class="card-body">
                        <p>//TODO add a brief description</p>
                        <p>//TODO add a table listing practiceHacker features</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
