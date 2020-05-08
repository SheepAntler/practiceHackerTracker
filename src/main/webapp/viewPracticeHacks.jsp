<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Practice Hacks</h1>
        <%--if you're a practiceHacker you'll just see hacks for your instrument/skill level--%>
        <c:if test="${pageContext.request.isUserInRole('practiceHacker')}">
            <h2 class="subHeading text-center">Tips, Tricks, and Ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
            <c:choose>
                <c:when test="${!empty personalPracticeHacks}">
                    <c:forEach var="practiceHack" items="${personalPracticeHacks}">
                        <p>Author: ${practiceHack.user.firstName} ${practiceHack.user.lastName}</p>
                        <p>${practiceHack.practiceHack}</p>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h2>There isn't any content to display yet.</h2>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${pageContext.request.isUserInRole('student')}">
            <c:choose>
                <c:when test="${practiceHacksFromTeacher != null}">
                    <h2 class="subHeading text-center">Here are your teacher's tips, tricks, and ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
                    <c:forEach var="practiceHack" items="${practiceHacksFromTeacher}">
                        <p>${practiceHack.practiceHack}</p>
                    </c:forEach>
                </c:when>
                <c:when test="${practiceHacksFromTeacher == null && personalPracticeHacks != null}">
                    <h2 class="subHeading text-center">Looks like your teacher hasn't added any Practice Hacks yet. Here are some other teachers' ideas in the meantime!</h2>
                    <h2 class="subHeading text-center">Tips, Tricks, and Ideas for ${user.instrument.skillLevel} ${user.instrument.instrument} Players</h2>
                    <c:forEach var="practiceHack" items="${personalPracticeHacks}">
                        <p>Author: ${practiceHack.user.firstName} ${practiceHack.user.lastName} from ${practiceHack.user.city}, ${practiceHack.user.state}</p>
                        <p>${practiceHack.practiceHack}</p>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h2>There isn't any content to display yet.</h2>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${pageContext.request.isUserInRole('teacher')}">
            <form action="practiceHacks">
                <h2 class="subHeading text-center">Please Select the Practice Hacks you'd like to View:</h2>
                <label class="sr-only" for="practiceHackView">Please Select the Practice Hacks you'd like to View</label>
                <select name="practiceHackView" id="practiceHackView" class="form-control">
                    <option value="allHacks">Show Me All Practice Hacks</option>
                    <option value="authorMode">Show Me Practice Hacks I've Written (Newest to Oldest)</option>
                    <option value="practiceMode">Show Me Practice Hacks for my Own Practice</option>
                </select>
                <button type="submit" class="btn btn-secondary">Get Practice Hacks</button>
            </form>

            <c:if test="${practiceHackViewSelected == true}">
                <c:if test="${allPracticeHacks != null}">
                    <c:choose>
                        <c:when test="${!empty allPracticeHacks}">
                            <p>This will be a jQuery table</p>
                            <p>${allPracticeHacks}</p>
                        </c:when>
                        <c:otherwise>
                            <p>Nobody has written any practice hacks yet. Would you like to <a href="practiceHackWriter.jsp">get the ball rolling</a>?</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test="${myPracticeHacks != null}">
                    <c:choose>
                        <c:when test="${!empty myPracticeHacks}">
<%--                            <p>These will have "edit" and "delete" buttons next to them</p>--%>
<%--                            <p>${myPracticeHacks}</p>--%>
                            <c:forEach var="practiceHack" items="${user.practiceHacks}">
                                <h3 class="minorHeading">${practiceHack.instrument}: ${practiceHack.skillLevel}</h3>
                                <p>${practiceHack.practiceHack}</p>
                                <form action="getPracticeHack">
                                    <input type="hidden" name="practiceHackToEdit" value="${practiceHack.id}">
                                    <button type="submit" class="btn btn-secondary">Edit</button>
                                </form>
                                <form action="deletePracticeHack">
                                    <button type="submit" class="btn btn-dark">Delete</button>
                                </form>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>You haven't written any practice hacks yet. Would you like to <a href="practiceHackWriter.jsp">create one</a>?</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test="${personalPracticeHacks != null}">
                    <c:choose>
                        <c:when test="${!empty personalPracticeHacks}">
                            <p>These will be output in a jQuery table like the other views</p>
                            <p>${personalPracticeHacks}</p>
                        </c:when>
                        <c:otherwise>
                            <p>There's nothing to show here...yet. Would you like to <a href="practiceHackWriter.jsp">add your own idea</a>?</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:if>
            <c:remove var="practiceHackViewSelected" scope="session" />
        </c:if>
    </div>
</body>
</html>
