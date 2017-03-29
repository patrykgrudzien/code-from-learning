<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
    Student confirmed: ${student.firstName} ${student.lastName}
    <br>
    Country: ${student.country}
    <br>
    Favorite Language: ${student.favoriteLanguage}
    <br><br>
    Operating System:
    <ul>
         <c:forEach var="temp" items="${student.operatingSystem}">

             <li>${temp}</li>

         </c:forEach>
    </ul>
</body>
</html>
