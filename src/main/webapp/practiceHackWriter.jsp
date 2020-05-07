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
<%--        <form action="writePracticeHack">--%>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="skillLevel">This practice hack is for: </label>
                    <select name="skillLevel" class="form-control" id="skillLevel" required>
                        <option value="beginner">Beginners</option>
                        <option value="intermediate">Intermediates</option>
                        <option value="advanced">Advanced Students</option>
                        <option value="preProfessional">Collegiate Students/Pre-Professionals</option>
                        <option value="professional">Professionals</option>
                    </select>
                </div>
                <div class="form-group col-sm-6">
                    <label for="instrument">Instrument: </label>
                    <select name="instrument" class="form-control" id="instrument">
                        <option value="${user.instrument.instrument}">${user.instrument.instrument}</option>
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
                    <button type="submit" class="btn btn-secondary">Update Practice Hack</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-secondary">Save Practice Hack</button>
                    <button type="reset" class="btn btn-dark">Start Over</button>
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
