<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/generalNavBar.jsp"%>
    <h1 class="container text-center">Sign Up!</h1>
    <form>
        <label for="username">Username: </label>
        <input type="text" id="username">

        <label for="password">Password: </label>
        <input type="text" id="password">

        <label for="repeatPassword">Retype Password: </label>
        <input type="text" id="repeatPassword">

        <label for="firstName">First Name: </label>
        <input type="text" id="firstName">

        <label for="lastName">Last Name: </label>
        <input type="text" id="lastName">

        <label for="email">Email: </label>
        <input type="text" id="email">

        <label for="accountTypes">Account Type</label>
        <select name="accountTypes" id="accountTypes">
            <option value="teacher">Teacher</option>
            <option value="student">Student</option>
            <option value="practiceHacker">Practice Hacker</option>
        </select>

        <div class="hidden" id="teacher">
            <h3>Studio Information</h3>

            <label for="studioInstrument">Instrument: </label>
            <input type="text" id="studioInstrument">

            <label for="studioName">Studio Name: </label>
            <input type="text" id="studioName">

            <label for="studioAddress">Street Address: </label>
            <input type="text" id="studioAddress">

            <label for="studioCity">City: </label>
            <input type="text" id="studioCity">

            <label for="studioState">State: </label>
            <input type="text" id="studioState">

            <label for="studioZip">Zip Code: </label>
            <input type="text" id="studioZip">
        </div>

        <div class="hidden" id="student">
            <h3>Personal Information</h3>

            <label for="studentInstrument">Instrument: </label>
            <input type="text" id="studentInstrument">

            <label for="studentSkillLevel">Skill Level: </label>
            <select name="skillLevel" id="studentSkillLevel">
                <option value="beginner">Beginner</option>
                <option value="intermediate">Intermediate</option>
                <option value="advanced">Advanced</option>
                <option value="preProfessional">Pre-Professional</option>
            </select>

            <label for="birthDate">Date of Birth: </label>
            <input type="date" id="birthDate">

            <label for="studentAddress">Street Address: </label>
            <input type="text" id="studentAddress">

            <label for="studentCity">City: </label>
            <input type="text" id="studentCity">

            <label for="studentState">State: </label>
            <input type="text" id="studentState">

            <label for="studentZip">Zip Code: </label>
            <input type="text" id="studentZip">
        </div>

        <div class="hidden" id="practiceHacker">
            <h3>Personal Information</h3>

            <label for="instrument">Instrument: </label>
            <input type="text" id="instrument">

            <label for="skillLevel">Skill Level: </label>
            <select name="skillLevel" id="skillLevel">
                <option value="beginner">Beginner</option>
                <option value="intermediate">Intermediate</option>
                <option value="advanced">Advanced</option>
                <option value="preProfessional">Pre-Professional</option>
                <option value="professional">Professional</option>
            </select>

            <label for="address">Street Address: </label>
            <input type="text" id="address">

            <label for="city">City: </label>
            <input type="text" id="city">

            <label for="state">State: </label>
            <input type="text" id="state">

            <label for="zip">Zip Code: </label>
            <input type="text" id="zip">
        </div>

        <div>
            I will be here no matter what.
        </div>
        <br><br>
        <button class="btn btn-dark">Create My Account</button>
    </form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/responsiveForm.js"></script>
</body>
</html>
