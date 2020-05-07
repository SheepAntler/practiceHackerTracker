<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox writerBox">
        <h1 class="mainHeading text-center">Add a Practice Hack</h1>
        <hr />
        <form action="writePracticeHack">
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
                        <option value="instrument">${user.instrument.instrument}</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="editor">Practice Hack: </label>
                <textarea id="editor" name="practiceHack"></textarea>
                <%-- TODO In edit mode: output the current practice hack text between the textarea tags! --%>
                <%-- TODO use the following commented-out code to help you select a particular hack to edit! --%>
<%--                <form action="closeStudio">--%>
<%--                    <input type="hidden" name="studioToClose" value="${studio.id}"/>--%>
<%--                    <button type="submit">Close Studio</button>--%>
<%--                </form>--%>
            </div>
            <br><br>
            <button type="submit" class="btn btn-secondary">Save Log</button>
            <button type="reset" class="btn btn-dark">Start Over</button>
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
