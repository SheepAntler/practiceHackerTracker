<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/9/20
  Time: 3:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="templates/head.jsp"%>

<html>
<body>
<%@include file="templates/studentNavBar.jsp"%>
    <div class="container textBox">
        <h1 class="mainHeading text-center">Hi, ${pageContext.request.getRemoteUser()}! You must be a STUDENT.</h1>
    </div>
</body>
</html>

