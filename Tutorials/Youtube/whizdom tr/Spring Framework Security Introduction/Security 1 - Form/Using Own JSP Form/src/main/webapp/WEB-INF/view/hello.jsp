<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true" %>
<html>
<body>

    <h3>Message : ${message}</h3>
    <h3>Username : ${username}</h3>

    <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>

</body>
</html>
