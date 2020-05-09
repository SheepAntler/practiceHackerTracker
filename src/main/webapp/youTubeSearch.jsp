<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox youTubeBox">
        <h1 class="mainHeading text-center">YouTube Search</h1>
        <p>Listening and playing along with recordings is a meaningful way to familiarize yourself with new repertoire.
           Use our in-app search to find a few recordings to inspire your practice session!</p>

        <form action="youTubeSearch">
            <label for="userSearch">What would you like to watch?</label>
            <input type="text" id="userSearch" name="userSearch">
            <button type="submit" class="btn btn-secondary">Search!</button>
            <button type="reset" class="btn btn-dark">Clear</button>
        </form>

        <c:if test="${searchResults != null}">
            <c:choose>
                <c:when test="${!empty searchResults}">
                    <c:forEach var="result" items="${searchResults}">
                        <iframe title="youTubeVideoPlayer" class="ytplayer" type="text/html" width="480" height="360"
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
