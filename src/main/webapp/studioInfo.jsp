<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">My Studio</h1>

        <c:choose>
            <c:when test="${studentStudio != null}">
                <p>${studentStudio}</p>
                <button class="btn btn-secondary">Leave this Studio</button>
            </c:when>
            <c:otherwise>
                <h2 class="subHeading text-center">You haven't joined a studio yet!</h2>
                <form action="studioSearch">
                    <label for="searchParameter">Search for ${user.instrument.instrument} studios in: </label>
                    <select name="searchParameter" id="searchParameter" class="form-control" required>
                        <option value="allStudios">All 50 States!</option>
                        <option value="state">${user.state}</option>
                        <option value="city">${user.city}, ${user.state}</option>
                    </select>
                    <button type="submit" class="btn btn-secondary">Find Studios</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
