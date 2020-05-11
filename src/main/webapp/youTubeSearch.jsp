<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox youTubeBox">
        <h1 class="mainHeading text-center">YouTube Search</h1>
        <hr />
        <p class="text-center mb-4">Listening and playing along with recordings is a meaningful way to familiarize yourself with new repertoire.
           Use our in-app search to find a few recordings to inspire your practice session!</p>

        <form action="youTubeSearch" class="mt-4 mb-4 text-center">
            <label for="userSearch" class="subHeading">What would you like to watch?</label>
            <input type="text" id="userSearch" name="userSearch" class="form-control mx-auto col-6">
            <div class="row buttonContainer mt-4">
                <button type="submit" class="btn btn-secondary button smallButton col-3">Search!</button>
            </div>
        </form>

        <c:if test="${searchResults != null}">
            <c:choose>
                <c:when test="${!empty searchResults}">
                    <hr class="mt-4"/>
                    <c:forEach var="result" items="${searchResults}">
                        <iframe title="youTubeVideoPlayer" class="ytplayer ml-4" type="text/html" width="480" height="360"
                                src="https://www.youtube.com/embed/${result.id.videoId}?autoplay=0"
                                frameborder="0"></iframe>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h2 class="subHeading text-center">We're sorry; that search didn't yield any results. Try again!</h2>
                </c:otherwise>
            </c:choose>
        </c:if>
    </div>
</body>
</html>
