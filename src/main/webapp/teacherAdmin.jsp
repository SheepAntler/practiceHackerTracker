<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Manage Your Studios</h1>
        <hr />
        <c:if test="${successMessage != null}">
            <p class="text-success text-center">${successMessage}</p>
        </c:if>
        <div class="hiddenDelete">
            <h2 class="text-warning text-center">Warning: deleting a studio cannot be undone!</h2>
            <p class="text-warning text-center">You will lose track of all students of the studio you choose to delete.</p>
        </div>
        <div class="card-deck studioCards mt-4">
            <c:forEach var="studio" items="${user.studios}">
                    <div class="card bg-dark mb-2 text-center indexCard" style="min-width: 18rem; max-width: 20rem;">
                        <div class="card-header indexCardHeader bg-black">
                            <h3 class="card-title">${studio.instrument} Studio at ${studio.organizationName}</h3>
                        </div>
                        <div class="card-body">
                            <p>${studio.streetAddress}</p>
                            <p>${studio.city}, ${studio.state} ${studio.zipCode}</p>
                            <p>students: ${studio.studentsInStudio.size()}</p>
                        </div>
                        <div class="hiddenDelete">
                            <form action="closeStudio">
                                <input type="hidden" name="studioToClose" value="${studio.id}"/>
                                <div class="row buttonContainer">
                                    <button type="submit" class="btn btn-danger button smallButton col-10">Close Studio</button>
                                </div>
                            </form>
                            <div class="row buttonContainer mt-2 mb-2">
                                <button class="showHideDelete btn btn-secondary button smallButton col-10">Never mind!</button>
                            </div>
                        </div>
                    </div>
            </c:forEach>
        </div>
        <div class="row buttonContainer mt-4 mb-4">
            <button class="showHideAdd btn btn-secondary button smallButton col-5">Add a Studio</button>
            <button class="showHideDelete btn btn-danger button smallButton col-5">Close a Studio</button>
        </div>
        <div id="hiddenAdd">
            <hr />
            <h2 class="subHeading text-center">Create a New Studio</h2>
            <hr />
            <form action="createStudio">
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="studioInstrument">Instrument: </label>
                        <input type="text" class="form-control" id="studioInstrument" name="studioInstrument" required pattern="[A-Z][a-z]*(\s[A-Z][a-z]*)*"
                               oninvalid="setCustomValidity('Please enter a capitalized instrument name here.')" oninput="setCustomValidity('')">
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
                        <input type="text" class="form-control" id="studioCity" name="studioCity" required pattern="[A-Z][a-z]*(\s[A-Z][a-z]*)*"
                               oninvalid="setCustomValidity('Please enter a capitalized city name.')" oninput="setCustomValidity('')">
                    </div>
                    <div class="form-group col-sm-2">
                        <label for="studioState">State: </label>
                        <input type="text" class="form-control" id="studioState" name="studioState" required pattern="[A-Z]{2}"
                               oninvalid="setCustomValidity('Please enter a completely capitalized state abbreviation.')" oninput="setCustomValidity('')">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="studioZip">Zip Code: </label>
                        <input type="text" class="form-control" id="studioZip" name="studioZip" required pattern="\d{5}"
                               oninvalid="setCustomValidity('Please enter a 5-digit zip code.')" oninput="setCustomValidity('')">
                    </div>
                </div>
                <div class="row buttonContainer mt-2">
                    <button type="submit" class="btn btn-success button smallButton col-5">Create Studio</button>
                    <button class="showHideAdd btn btn-dark button smallButton col-5">Never Mind!</button>
                </div>
            </form>
        </div>
    <script src="js/revealDiv.js"></script>
</body>
</html>
