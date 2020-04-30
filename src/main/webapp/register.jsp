<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
    <div class="container textBox formBox">
        <h1 class="text-center mainHeading">Create an Account</h1>
        <form>
            <hr />
            <h3 class="minorHeading text-center">A Little Basic Info...</h3>
            <hr />
            <div class="form-group">
                <label for="username">Username: </label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="password">Password: </label>
                    <input type="text" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-group col-sm-6">
                    <label for="repeatPassword">Retype Password: </label>
                    <input type="text" class="form-control" id="repeatPassword" name="repeatPassword" required>
                </div>
            </div>
            <div class="form-group">
                <label for="firstName">First Name: </label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name: </label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="email" class="form-control" id="email" aria-describedby="emailInfo" name="email" required>
                <small id="emailInfo" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="accountTypes">Account Type</label>
                <select name="accountTypes" class="form-control" id="accountTypes" required>
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
                        <input type="text" class="form-control" id="studioInstrument">
                    </div>
                    <div class="form-group col-sm-6">
                        <label for="studioName">Studio Name: </label>
                        <input type="text" class="form-control" id="studioName" name="studioName">
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
            </div>

            <div class="hidden" id="student">
                <hr />
                <h3 class="minorHeading text-center">Additional Information</h3>
                <hr />
                <div class="row">
                    <div class="form-group col-sm-4">
                        <label for="studentInstrument">Instrument: </label>
                        <input type="text" class="form-control" id="studentInstrument" name="studentInstrument" required>
                    </div>
                    <div class="form-group col-sm-4">
                    <label for="studentSkillLevel">Skill Level: </label>
                        <select name="studentSkillLevel" class="form-control" id="studentSkillLevel" required>
                            <option value="beginner">Beginner</option>
                            <option value="intermediate">Intermediate</option>
                            <option value="advanced">Advanced</option>
                            <option value="preProfessional">Collegiate/Pre-Professional</option>
                        </select>
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="birthDate">Date of Birth: </label>
                        <input type="date" class="form-control" id="birthDate" name="birthDate" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="studentAddress">Street Address: </label>
                    <input type="text" class="form-control" id="studentAddress" name="studentAddress" required>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="studentCity">City: </label>
                        <input type="text" class="form-control" id="studentCity" name="studentCity" required>
                    </div>
                    <div class="form-group col-sm-2">
                        <label for="studentState">State: </label>
                        <input type="text" class="form-control" id="studentState" name="studentState" required>
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="studentZip">Zip Code: </label>
                        <input type="text" class="form-control" id="studentZip" name="studentZip" required>
                    </div>
                </div>
            </div>

            <div class="hidden" id="practiceHacker">
                <hr />
                <h3 class="minorHeading text-center">Additional Information</h3>
                <hr />
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="instrument">Instrument: </label>
                        <input type="text" class="form-control col-sm-6" id="instrument" name="instrument" required>
                    </div>
                    <div class="form-group col-sm-6">
                    <label for="skillLevel">Skill Level: </label>
                        <select name="skillLevel" class="form-control col-sm-6" id="skillLevel" required>
                            <option value="beginner">Beginner</option>
                            <option value="intermediate">Intermediate</option>
                            <option value="advanced">Advanced</option>
                            <option value="preProfessional">Pre-Professional</option>
                            <option value="professional">Professional</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address">Street Address: </label>
                    <input type="text" class="form-control" id="address" name="address" required>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="city">City: </label>
                        <input type="text" class="form-control" id="city" name="city" required>
                    </div>
                    <div class="form-group col-sm-2">
                        <label for="state">State: </label>
                        <input type="text" class="form-control" id="state" name="state" required>
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="zip">Zip Code: </label>
                        <input type="text" class="form-control" id="zip" name="zip" required>
                    </div>
                </div>
            </div>
            <br><br>
            <button type="submit" class="btn btn-dark">Create My Account</button>
        </form>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/responsiveForm.js"></script>
</body>
</html>
