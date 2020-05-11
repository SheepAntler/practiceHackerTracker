<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html>
<body>
<%@include file="templates/navbar.jsp"%>
<div class="container textBox">
    <h1 class="mainHeading text-center">My Profile</h1>
    <div class="container-fluid">
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
                <th>User ID</th>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Instrument</th>
                <th>Role</th>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.instrument.instrument}</td>
                    <td>${user.role.role}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>

</body>
</html>
