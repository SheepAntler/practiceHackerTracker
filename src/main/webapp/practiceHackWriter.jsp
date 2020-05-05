<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox writerBox">
        <h1 class="mainHeading text-center">Add a Practice Hack</h1>
        <hr />
        <form>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="studentSkillLevel">This practice hack is for: </label>
                    <select name="studentSkillLevel" class="form-control" id="studentSkillLevel" required>
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
                <textarea id="editor" name="notes"></textarea>
                <%-- TODO In edit mode: output the current practice hack text between the textarea tags! --%>
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
