<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">My Studio</h1>
        <hr />

        <c:if test="${successMessage != null}">
            <p class="text-success text-center">${successMessage}</p>
        </c:if>

        <c:choose>
            <c:when test="${studentStudio != null}">
                <h2 class="subHeading text-center">${studentStudio.teacher.firstName} ${studentStudio.teacher.lastName}'s ${studentStudio.instrument} Studio</h2>
                <p class="text-center">${studentStudio.organizationName}</p>
                <p class="text-center">${studentStudio.streetAddress}</p>
                <p class="text-center">${studentStudio.city}, ${studentStudio.state} ${studentStudio.zipCode}</p>
                <div class="row buttonContainer">
                    <button class="hideShow btn btn-danger button smallButton">Leave this Studio</button>
                </div>
                <hr />
                <div class="container" id="hiddenDiv">
                    <h3 class="minorHeading text-danger text-center">We're sorry to see you go; are you <i>certain</i> you wish to leave this studio?</h3>
                        <form action="leaveStudio" class="mt-2">
                            <div class="row buttonContainer">
                                <button type="submit" class="btn btn-danger button smallButton">Yes, I'm sure</button>
                            </div>
                        </form>
                    <div class="row buttonContainer mt-4">
                        <button class="hideShow btn btn-dark button smallButton">No; I'd like to stay</button>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h2 class="subHeading text-center">It looks like you aren't a member of any studios. Find one to join here!</h2>
                <form action="studioSearch" class="mb-4">
                    <label for="searchParameter">Search for ${user.instrument.instrument} studios in: </label>
                    <select name="searchParameter" id="searchParameter" class="form-control" required>
                        <option value="allStudios">All 50 States!</option>
                        <option value="state">${user.state}</option>
                        <option value="city">${user.city}, ${user.state}</option>
                    </select>
                    <div class="row buttonContainer mt-2">
                        <button type="submit" class="btn btn-secondary button smallButton col-4">Find Studios</button>
                    </div>
                </form>
                <c:if test="${studiosFound == true}">
                    <h2 class="subHeading text-center">${studioViewMessage}</h2>
                    <c:choose>
                        <c:when test="${availableStudios != null && !empty availableStudios}">
                            <form action="joinStudio">
                                <select name="studioOption" id="studioOption" class="form-control" required>
                                    <c:forEach var="studio" items="${availableStudios}">
                                        <option value="${studio.id}">${studio.teacher.firstName} ${studio.teacher.lastName}'s Studio at ${studio.organizationName} in ${studio.city}, ${studio.state}</option>
                                    </c:forEach>
                                </select>
                                <div class="row buttonContainer mt-2">
                                    <button type="submit" class="btn btn-success button smallButton col-4">Join Studio</button>
                                </div>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <p class="text-center">There are no available studios in your area at this time.</p>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:remove var="studiosFound" scope="session" />
                <c:remove var="availableStudios" scope="session" />
            </c:otherwise>
        </c:choose>
    </div>
    <script src="js/revealDiv.js"></script>
</body>
</html>
