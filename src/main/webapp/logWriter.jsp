<%-- This date output code is courtesy of TutorialsPoint --%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox writerBox">
        <h1 class="text-center mainHeading">Log a Practice Session</h1>
        <%
            Date dNow = new Date( );
            SimpleDateFormat ft =
                    new SimpleDateFormat ("E MM.dd.yyyy");
            out.print( "<h3 class=\"minorHeading text-center\">" + ft.format(dNow) + "</h3>");
        %>
        <hr />
        <form>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="startTime">Start Time: </label>
                    <input type="time" class="form-control" id="startTime" name="startTime" required>
                </div>
                <div class="form-group col-sm-6">
                    <label for="endTime">End Time: </label>
                    <input type="time" class="form-control" id="endTime" name="endTime" required>
                </div>
            </div>
            <div class="form-group">
                <label for="activities">What did you work on?</label>
                <input type="text" class="form-control" id="activities" name="activities" required>
            </div>
            <div class="form-group">
                <label for="editor">Notes: </label>
                <textarea id="editor" name="notes"></textarea>
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
