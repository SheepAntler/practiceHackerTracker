<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Manage Your Studios</h1>
        <c:forEach var="studio" items="${user.studios}">
            <p>${studio.instrument} at ${studio.organizationName}</p>
            <p>${studio.streetAddress}</p>
            <p>${studio.city}, ${studio.state} ${studio.zipCode}</p>
        </c:forEach>
        <div class="row">
            <button class="showHideAdd btn btn-dark">Add a Studio</button>
            <button class="showHideDelete btn btn-dark">Close a Studio</button>
        </div>
        <div id="hiddenAdd">
            <h2 class="subHeading">Create a New Studio</h2>
            <form action="createStudio">
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="studioInstrument">Instrument: </label>
                        <input type="text" class="form-control" id="studioInstrument" name="studioInstrument" required>
                    </div>
                    <div class="form-group col-sm-6">
                        <label for="studioName">Studio Organization: </label>
                        <input type="text" class="form-control" id="studioName" name="studioName" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="studioAddress">Street Address: </label>
                    <input type="text" class="form-control" id="studioAddress" name="studioAddress" required>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="studioCity">City: </label>
                        <input type="text" class="form-control" id="studioCity" name="studioCity" required>
                    </div>
                    <div class="form-group col-sm-2">
                        <label for="studioState">State: </label>
                        <input type="text" class="form-control" id="studioState" name="studioState" required>
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="studioZip">Zip Code: </label>
                        <input type="text" class="form-control" id="studioZip" name="studioZip" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-secondary">Create Studio</button>
                <button class="showHideAdd btn btn-dark">Never Mind!</button>
            </form>
        </div>
        <div id="hiddenDelete">
            <form action="closeStudio">
                <label for="studioToClose">Select the Studio you want to close:</label>
                <select id="studioToClose" class="form-control" name="studioToClose" required>
                    <c:forEach var="studio" items="${user.studios}">
                        <option value="${studio.id}">${studio.instrument} Studio at ${studio.organizationName}</option>
                    </c:forEach>
                </select>
                <p class="text-warning">Are you certain you want to close this studio? This action cannot be undone.</p>
                <button type="submit" class="btn btn-danger">Yes; close this studio</button>
            </form>
            <button class="showHideDelete btn btn-secondary">No; I'd like to keep this studio open</button>
        </div>
    </div>
    <script src="js/revealDiv.js"></script>
</body>
</html>
