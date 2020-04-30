<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox writerBox">
        <h1 class="text-center mainHeading">Comment on a Practice</h1>
        <hr />
        <h2 class="subHeading text-center">Log:</h2>
<%--TODO display the log that the teacher is commenting on--%>
        <form>
            <div class="form-group">
                <label for="editor">Comments: </label>
                <textarea id="editor" name="notes"></textarea>
            </div>
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
