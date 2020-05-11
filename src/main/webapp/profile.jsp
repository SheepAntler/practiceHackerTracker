<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp"%>

<html>
<body>
    <%@include file="templates/navbar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">My Profile</h1>
        <div class="accordion" id="profileViewer">
            <div class="card bg-dark text-light">
                <div class="card-header" id="viewProfile">
                    <h2 class="mb-0">
                        <button class="btn btn-link accordionLink" type="button" data-toggle="collapse" data-target="#teacherInfo" aria-expanded="true" aria-controls="teacherInfo">
                            View Profile
                        </button>
                    </h2>
                </div>
                <div id="teacherInfo" class="collapse show" aria-labelledby="viewProfile" data-parent="#profileViewer">
                    <div class="card-body">
                        <c:if test="${successMessage != null}">
                            <p class="text-success text-center">${successMessage}</p>
                        </c:if>
                        <table class="table table-striped table-dark">
                            <thead class="thead-dark">
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Username</th>
                                <th scope="col">Instrument</th>
                                <th scope="col">Skill Level</th>
                                <th scope="col">Email Address</th>
                                <th scope="col">Address</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="text-light"><i>${user.firstName} ${user.lastName}</i></td>
                                <td class="text-light"><i>${user.username}</i></td>
                                <td class="text-light"><i>${user.instrument.instrument}</i></td>
                                <td class="text-light"><i>${user.instrument.skillLevel}</i></td>
                                <td class="text-light"><i>${user.email}</i></td>
                                <td class="text-light"><i>${user.city}, ${user.state} ${user.zipCode}</i></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="card bg-dark text-light">
                <div class="card-header" id="editProfile">
                    <h2 class="mb-0">
                        <button class="btn btn-link collapsed accordionLink" type="button" data-toggle="collapse" data-target="#studentInfo" aria-expanded="false" aria-controls="studentInfo">
                            Edit Profile
                        </button>
                    </h2>
                </div>
                <div id="studentInfo" class="collapse" aria-labelledby="editProfile" data-parent="#profileViewer">
                    <div class="card-body">
                        <form action="editProfile">
                            <div class="form-group col-sm-4">
                                <label for="skillLevel">Update Skill Level</label>
                                <select name="skillLevel" class="form-control" id="skillLevel" required>
                                    <option value="beginner">Beginner</option>
                                    <option value="intermediate">Intermediate</option>
                                    <option value="advanced">Advanced</option>
                                    <option value="preProfessional">Collegiate/Pre-Professional</option>
                                    <option value="professional">Professional</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="email">Update Email: </label>
                                <input type="text" class="form-control" id="email" name="email" value="${user.email}" required>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="city">Update City: </label>
                                <input type="text" class="form-control" id="city" name="city" value="${user.city}" required>
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="state">Update State: </label>
                                <input type="text" class="form-control" id="state" name="state" value="${user.state}" required>
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="zip">Update Zip Code: </label>
                                <input type="text" class="form-control" id="zip" name="zip" value="${user.zipCode}" required>
                            </div>
                            <div class="row buttonContainer">
                                <button type="submit" class="btn btn-secondary button smallButton">Save Changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="card bg-dark text-light">
                <div class="card-header" id="deleteProfile">
                    <h2 class="mb-0">
                        <button class="btn btn-link collapsed accordionLink text-danger" type="button" data-toggle="collapse" data-target="#otherInfo" aria-expanded="false" aria-controls="otherInfo">
                            Delete Profile
                        </button>
                    </h2>
                </div>
                <div id="otherInfo" class="collapse" aria-labelledby="deleteProfile" data-parent="#profileViewer">
                    <div class="card-body">
                        <c:choose>
                            <c:when test="${pageContext.request.isUserInRole('teacher')}">
                                <p class="text-center text-warning">Once you delete your account, you will lose all of your logs, students, and studios, and all
                                        of the practice hacks you have written will be taken down.</p>
                            </c:when>
                            <c:when test="${pageContext.request.isUserInRole('student')}">
                                <p class="text-center text-warning">Once you delete your account, you will lose all of your logs and studios.</p>
                            </c:when>
                            <c:when test="${pageContext.request.isUserInRole('practiceHacker')}">
                                <p class="text-center text-warning">Once you delete your account, you will lose all of your logs.</p>
                            </c:when>
                        </c:choose>
                        <div class="row buttonContainer">
                            <a class="btn btn-danger button smallButton" href="confirmDelete.jsp">I understand; but I'd like to continue</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
