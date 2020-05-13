<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox formBox">
        <h1 class="text-center mainHeading">Create an Account</h1>
        <c:if test="${errorMessage != null}">
            <p class="text-danger text-center">${errorMessage}</p>
        </c:if>
        <form action="createAccount">
            <hr />
            <h3 class="minorHeading text-center">A Little Basic Info...</h3>
            <hr />
            <div class="form-group">
                <label for="username">Username: </label>
                <input type="text" class="form-control" id="username" name="j_username" required>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="password">Password: </label>
                    <input type="password" class="form-control" id="password" name="j_password" required onkeyup="checkPasswords();">
                </div>
                <div class="form-group col-sm-6">
                    <label for="confirmPassword">Confirm Password: </label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required onkeyup="checkPasswords();">
                    <span id="message"></span>
                </div>
            </div>
            <div class="form-group">
                <label for="firstName">First Name: </label>
                <input type="text" class="form-control" id="firstName" name="firstName" required value="${newUser.firstName}">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name: </label>
                <input type="text" class="form-control" id="lastName" name="lastName" required value="${newUser.lastName}">
            </div>
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="email" class="form-control" id="email" aria-describedby="emailInfo" name="email" required value="${newUser.email}">
                <small id="emailInfo" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="city">City: </label>
                    <input type="text" class="form-control" id="city" name="city" required pattern="([A-Z][a-z]+)\s*" value="${newUser.city}"
                           oninvalid="setCustomValidity('Please enter a capitalized city name.')" oninput="setCustomValidity('')">
                </div>
                <div class="form-group col-sm-2">
                    <label for="state">State: </label>
                    <input type="text" class="form-control" id="state" name="state" required pattern="[A-Z]{2}" value="${newUser.state}"
                           oninvalid="setCustomValidity('Please enter a fully-capitalized state abbreviation.')" oninput="setCustomValidity('')">
                </div>
                <div class="form-group col-sm-4">
                    <label for="zip">Zip Code: </label>
                    <input type="text" class="form-control" id="zip" name="zip" required pattern="\d{5}" value="${newUser.zipCode}"
                           oninvalid="setCustomValidity('Please enter a 5-digit zip code.')" oninput="setCustomValidity('')">
                </div>
            </div>
            <hr />
            <h3 class="minorHeading text-center">...and a Little Instrumental Info</h3>
            <hr />
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="instrument">Primary Instrument: </label>
                    <input type="text" class="form-control" id="instrument" name="instrument" required pattern="([A-Z][a-z]+)\s*" value="${newInstrument.instrument}"
                           oninvalid="setCustomValidity('Please enter a capitalized instrument name.')" oninput="setCustomValidity('')">
                </div>
                <div class="form-group col-sm-6">
                    <label for="skillLevel">Skill Level: </label>
                    <select name="skillLevel" class="form-control" id="skillLevel" required>
                        <option value="Beginner">Beginner</option>
                        <option value="Intermediate">Intermediate</option>
                        <option value="Advanced">Advanced</option>
                        <option value="Pre-Professional">Pre-Professional</option>
                        <option value="Professional">Professional</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="accountType">Account Type</label>
                <select name="accountType" class="form-control" id="accountType" required>
                    <option value="" disabled selected>I am a:</option>
                    <option value="teacher">Teacher: I have an active studio and want to monitor my students' practice habits</option>
                    <option value="student">Student: I am currently taking lessons</option>
                    <option value="practiceHacker">Practice Hacker: I am an amateur or professional musician looking for accountability</option>
                </select>
            </div>

            <div class="hidden" id="teacher">
                <hr />
                <h3 class="minorHeading text-center">Studio Information</h3>
                <hr />
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="studioInstrument">Instrument: </label>
                        <input type="text" class="form-control" id="studioInstrument" name="studioInstrument" pattern="([A-Z][a-z]+)\s*" value="${newStudio.instrument}"
                               oninvalid="setCustomValidity('Please enter a capitalized instrument name.')" oninput="setCustomValidity('')">
                    </div>
                    <div class="form-group col-sm-6">
                        <label for="studioName">Studio Organization: </label>
                        <input type="text" class="form-control" id="studioName" name="studioName" value="${newStudio.organizationName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="studioAddress">Street Address: </label>
                    <input type="text" class="form-control" id="studioAddress" name="studioAddress" value="${newStudio.streetAddress}">
                </div>
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="studioCity">City: </label>
                        <input type="text" class="form-control" id="studioCity" name="studioCity" pattern="([A-Z][a-z]+)\s*" value="${newStudio.city}"
                               oninvalid="setCustomValidity('Please enter a capitalized city name.')" oninput="setCustomValidity('')">
                    </div>
                    <div class="form-group col-sm-2">
                        <label for="studioState">State: </label>
                        <input type="text" class="form-control" id="studioState" name="studioState" pattern="[A-Z]{2}" value="${newStudio.state}"
                               oninvalid="setCustomValidity('Please enter a fully-capitalized state abbreviation.')" oninput="setCustomValidity('')">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="studioZip">Zip Code: </label>
                        <input type="text" class="form-control" id="studioZip" name="studioZip" pattern="\d{5}" value="${newStudio.zipCode}"
                               oninvalid="setCustomValidity('Please enter a 5-digit zip code.')" oninput="setCustomValidity('')">
                    </div>
                </div>
            </div>

            <div class="hidden" id="student">
                <hr />
                <h3 class="minorHeading text-center">Additional Information</h3>
                <hr />
                <div class="form-group">
                    <label for="birthDate">Date of Birth: </label>
                    <input type="date" class="form-control" id="birthDate" name="birthDate" value="${newUser.birthDate}">
                </div>
            </div>
            <br><br>
            <div class="row buttonContainer">
                <button type="submit" class="btn btn-secondary button smallButton col-5">Create My Account</button>
                <button type="reset" class="btn btn-dark button smallButton col-5">Start Over</button>
            </div>
        </form>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/responsiveForm.js"></script>
<script src="js/passwordCheck.js"></script>
</body>
</html>
