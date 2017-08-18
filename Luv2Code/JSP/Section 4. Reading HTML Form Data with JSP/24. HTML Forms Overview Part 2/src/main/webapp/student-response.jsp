<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation Title</title>
</head>
<body>

    The student is confirmed: ${param.firstName} ${param.lastName}

    <br><br>

    <%-- ALTERNATIVE WAY OF GETTING INFORMATION FROM "FORM" IS: "request.getParameter();" --%>
    <%-- BUT IT IS "AN OLDER" OPTION OR LET'S SAY "LONGER" --%>
    Older option to get informations from form:
    <%= request.getParameter("firstName") %> <%=request.getParameter("lastName") %>

</body>
</html>
