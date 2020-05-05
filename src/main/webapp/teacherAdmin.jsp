<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1>Manage Your Studios</h1>
        <c:forEach var="studio" items="${user.studios}">
            <p>${studio}</p>
            <form action="closeStudio">
                <input type="hidden" name="studioToClose" value="${studio.id}"/>
                <button type="submit">Close Studio</button>
            </form>
        </c:forEach>
    </div>
    <script src="js/revealDiv.js"></script>
</body>
</html>
