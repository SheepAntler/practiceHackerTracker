<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('.practiceHackTable').DataTable();
    });
</script>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="textBox writerBox">
        <h1 class="mainHeading text-center">Practice Hacks</h1>
        <hr class="mb-4"/>
        <c:if test="${successMessage != null}">
            <p class="text-success text-center">${successMessage}</p>
        </c:if>
        <%--if you're a practiceHacker you'll just see hacks for your instrument/skill level--%>
        <c:if test="${pageContext.request.isUserInRole('practiceHacker')}">
            <h2 class="subHeading text-center">Tips, Tricks, and Ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
            <hr />
            <c:choose>
                <c:when test="${!empty personalPracticeHacks}">
                    <div class="container-fluid">
                        <table class="display practiceHackTable" cellspacing="0" width="100%">
                            <thead>
                                <th>Author</th>
                                <th>Practice Hack</th>
                            </thead>
                            <tbody>
                                <c:forEach var="practiceHack" items="${personalPracticeHacks}">
                                    <tr>
                                        <td>${practiceHack.user.firstName} ${practiceHack.user.lastName}</td>
                                        <td>${practiceHack.practiceHack}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <h2 class="text-center">There isn't any content to display yet.</h2>
                </c:otherwise>
            </c:choose>
        </c:if>
        <%-- If you're a student, you will see either just your teacher's practice hacks for your instrument/skill level, or all practice hacks for your instrument/skill level if your teacher hasn't written any hacks yet--%>
        <c:if test="${pageContext.request.isUserInRole('student')}">
            <c:choose>
                <c:when test="${practiceHacksFromTeacher != null}">
                    <h2 class="subHeading text-center">Here are your teacher's tips, tricks, and ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
                    <hr />
                    <div class="container-fluid">
                        <table class="display practiceHackTable" cellspacing="0" width="100%">
                            <thead>
                                <th>Practice Hack</th>
                            </thead>
                            <tbody>
                                <c:forEach var="practiceHack" items="${practiceHacksFromTeacher}">
                                    <tr>
                                        <td>${practiceHack.practiceHack}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:when test="${practiceHacksFromTeacher == null && personalPracticeHacks != null}">
                    <h2 class="subHeading text-center">Looks like your teacher hasn't added any Practice Hacks yet. Here are some other teachers' ideas in the meantime!</h2>
                    <hr />
                    <h2 class="subHeading text-center">Tips, Tricks, and Ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
                    <div class="container-fluid">
                        <table class="display practiceHackTable" cellspacing="0" width="100%">
                            <thead>
                                <th>Author</th>
                                <th>Practice Hack</th>
                            </thead>
                            <tbody>
                                <c:forEach var="practiceHack" items="${personalPracticeHacks}">
                                    <tr>
                                        <td>${practiceHack.user.firstName} ${practiceHack.user.lastName}</td>
                                        <td>${practiceHack.practiceHack}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <h2>There isn't any content to display yet.</h2>
                </c:otherwise>
            </c:choose>
        </c:if>
        <%-- If you're a teacher, you will be able to choose between three practice hack views --%>
        <c:if test="${pageContext.request.isUserInRole('teacher')}">
            <form action="practiceHacks" class="mb-4">
                <h2 class="subHeading text-center">Please Select the Practice Hacks you'd like to View:</h2>
                <label class="sr-only" for="practiceHackView">Please Select the Practice Hacks you'd like to View</label>
                <select name="practiceHackView" id="practiceHackView" class="form-control">
                    <option value="allHacks">Show Me All Practice Hacks</option>
                    <option value="authorMode">Show Me Practice Hacks I've Written (Newest to Oldest)</option>
                    <option value="practiceMode">Show Me Practice Hacks for my Own Practice</option>
                </select>
                <div class="row buttonContainer mt-4">
                    <button type="submit" class="btn btn-secondary button smallButton col-4">Get Practice Hacks</button>
                </div>
            </form>
            <hr class="mb-4"/>
            <c:if test="${practiceHackViewSelected == true}">
                <c:if test="${allPracticeHacks != null}">
                    <c:choose>
                        <c:when test="${!empty allPracticeHacks}">
                            <h2 class="subHeading text-center">All Practice Hacks</h2>
                            <hr />
                            <div class="container-fluid">
                                <table class="display practiceHackTable" cellspacing="0" width="100%">
                                    <thead>
                                        <th>Instrument</th>
                                        <th>Skill Level</th>
                                        <th>Practice Hack</th>
                                        <th>Author</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="practiceHack" items="${allPracticeHacks}">
                                            <tr>
                                                <td>${practiceHack.instrument}</td>
                                                <td>${practiceHack.skillLevel}</td>
                                                <td>${practiceHack.practiceHack}</td>
                                                <td>${practiceHack.user.firstName} ${practiceHack.user.lastName}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <p class="text-center">Nobody has written any practice hacks yet. Would you like to <a href="practiceHackWriter.jsp">get the ball rolling</a>?</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test="${myPracticeHacks != null}">
                    <c:choose>
                        <c:when test="${!empty myPracticeHacks}">
                            <c:forEach var="practiceHack" items="${user.practiceHacks}">
                                <h3 class="minorHeading text-center mt-4">${practiceHack.instrument}: ${practiceHack.skillLevel}</h3>
                                <hr />
                                <p class="text-center">${practiceHack.practiceHack}</p>
                                <form action="getPracticeHack" class="mb-2">
                                    <input type="hidden" name="practiceHackToEdit" value="${practiceHack.id}">
                                    <div class="row buttonContainer">
                                        <button type="submit" class="btn btn-secondary button tinyButton col-3">Edit</button>
                                    </div>
                                </form>
                                <form action="deletePracticeHack" class="mb-4">
                                    <input type="hidden" name="practiceHackToDelete" value="${practiceHack.id}">
                                    <div class="row buttonContainer">
                                        <button type="submit" class="btn btn-danger button tinyButton col-3">Delete*</button>
                                    </div>
                                    <p class="text-center"><small class="text-danger">*Think carefully before deleting; this action cannot be undone.</small></p>
                                </form>
                                <hr class="mb-4" />
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p class="text-center">You haven't written any practice hacks yet. Would you like to <a href="practiceHackWriter.jsp">create one</a>?</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test="${personalPracticeHacks != null}">
                    <c:choose>
                        <c:when test="${!empty personalPracticeHacks}">
                            <h2 class="subHeading text-center">Practice Hacks Tailored to You</h2>
                            <hr />
                            <div class="container-fluid">
                                <table class="display practiceHackTable" cellspacing="0" width="100%">
                                    <thead>
                                        <th>Author</th>
                                        <th>Practice Hack</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="practiceHack" items="${personalPracticeHacks}">
                                            <tr>
                                                <td>${practiceHack.user.firstName} ${practiceHack.user.lastName}</td>
                                                <td>${practiceHack.practiceHack}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <p class="text-center">There's nothing to show here...yet. Would you like to <a href="practiceHackWriter.jsp">add your own idea</a>?</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:if>
            <c:remove var="practiceHackViewSelected" scope="session" />
        </c:if>
    </div>
    <script src="js/revealDiv.js"></script>
</body>
</html>
