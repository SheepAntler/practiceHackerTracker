<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">My Studio</h1>

        <c:choose>
            <c:when test="${studentStudio != null}">
                <p>${studentStudio.teacher.firstName} ${studentStudio.teacher.lastName}'s ${studentStudio.instrument} Studio</p>
                <p>${studentStudio.organizationName}</p>
                <p>${studentStudio.streetAddress}</p>
                <p>${studentStudio.city}, ${studentStudio.state} ${studentStudio.zipCode}</p>
                <button class="btn btn-secondary" onClick="revealHiddenDiv()">Leave this Studio</button>
                <div class="container" id="hiddenDiv">
                    <p>We're sorry to see you go; are you <i>certain</i> you wish to leave this studio?</p>
                    <form action="leaveStudio">
                        <button type="submit" class="btn btn-secondary">Yes, I'm sure</button>
                    </form>
                    <button class="btn btn-dark" onClick="revealHiddenDiv()">No; I'd like to stay</button>
                </div>
            </c:when>
            <c:otherwise>
                <h2 class="subHeading text-center">It looks like you aren't a member of any studios. Find one to join here!</h2>
                <form action="studioSearch">
                    <label for="searchParameter">Search for ${user.instrument.instrument} studios in: </label>
                    <select name="searchParameter" id="searchParameter" class="form-control" required>
                        <option value="allStudios">All 50 States!</option>
                        <option value="state">${user.state}</option>
                        <option value="city">${user.city}, ${user.state}</option>
                    </select>
                    <button type="submit" class="btn btn-secondary">Find Studios</button>
                </form>
                <c:if test="${studiosFound == true}">
                    <c:choose>
                        <c:when test="${availableStudios != null && !empty availableStudios}">
                            <form action="joinStudio">
                                <select name="studioOption" id="studioOption" class="form-control" required>
                                    <c:forEach var="studio" items="${availableStudios}">
                                        <option value="${studio.id}">${studio.user.firstName} ${studio.user.lastName}'s Studio</option>
                                    </c:forEach>
                                </select>
                                <button type="submit" class="btn btn-secondary">Join Studio</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <p>There are no available studios in your area at this time.</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:remove var="studiosFound" scope="session" />
                <c:remove var="availableStudios" scope="session" />
            </c:otherwise>
        </c:choose>
    </div>

<%--<script>--%>
<%--    const revealHiddenDiv = () => {--%>
<%--        let hiddenDiv = document.getElementById("hiddenDiv");--%>
<%--        if (hiddenDiv.style.display === "none") {--%>
<%--            hiddenDiv.style.display = "block";--%>
<%--        } else {--%>
<%--            hiddenDiv.style.display = "none";--%>
<%--        }--%>
<%--    };--%>
<%--</script>--%>
    <script src="js/revealDiv.js"></script>
</body>
</html>
