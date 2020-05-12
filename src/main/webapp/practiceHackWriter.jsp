<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox writerBox">
        <h1 class="mainHeading text-center">Add a Practice Hack</h1>
        <hr />
        <c:choose>
            <c:when test="${practiceHackToEdit != null}">
                <form action="editPracticeHack">
            </c:when>
            <c:otherwise>
                <form action="writePracticeHack">
            </c:otherwise>
        </c:choose>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="skillLevel">This practice hack is for: </label>
                    <select name="skillLevel" class="form-control" id="skillLevel" required>
                        <option value="Beginner">Beginners</option>
                        <option value="Intermediate">Intermediates</option>
                        <option value="Advanced">Advanced Students</option>
                        <option value="Pre-Professional">Collegiate Students/Pre-Professionals</option>
                        <option value="Professional">Professionals</option>
                    </select>
                </div>
                <div class="form-group col-sm-6">
                    <label for="instrument">Instrument: </label>
                    <select name="instrument" class="form-control" id="instrument" required>
<%--                        <c:forEach var="studio" items="${user.studios}">--%>
<%--                            <option value="${studio.instrument}">${studio.instrument}</option>--%>
<%--                        </c:forEach>--%>
                        <c:forEach var="instrument" items="${teacherInstruments}">
                            <option value="${instrument}">${instrument}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="editor">Practice Hack: </label>
                <textarea id="editor" name="practiceHack">${practiceHackToEdit.practiceHack}</textarea>
            </div>
            <br><br>
            <c:choose>
                <c:when test="${practiceHackToEdit != null}">
                    <div class="row buttonContainer">
                        <button type="submit" class="btn btn-secondary button smallButton col-4">Update Practice Hack</button>
                        <a class="btn btn-dark button smallButton col-4" href="viewPracticeHacks.jsp">Back</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row buttonContainer">
                        <button type="submit" class="btn btn-secondary button smallButton col-4">Save Practice Hack</button>
                        <button type="reset" class="btn btn-dark button smallButton col-4">Start Over</button>
                    </div>
                </c:otherwise>
            </c:choose>
        </form>
    </div>
    <script>
        ClassicEditor
            .create( document.querySelector( '#editor' ) )
            .then( editor => {
                console.log( editor );
            } )
            .catch( error => {
                console.error( error );
            } );
    </script>
</body>
</html>
