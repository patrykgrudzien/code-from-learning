<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

    <form:form action="processForm" modelAttribute="student" method="GET">

        <%-- Property of Student class (firstName is populated by getFirstName() method --%>
        First name: <form:input path="firstName"/>

        <br><br>

        <%-- Property of Student class --%>
        Last name: <form:input path="lastName"/>

        <br><br>

        Country:
        <form:select path="country">

            <%-- HARDCODED OPTIONS --%>
            <%--<form:option value="Brazil" label="Brazil"/>--%>
            <%--<form:option value="Poland" label="Poland"/>--%>
            <%--<form:option value="Germany" label="Germany"/>--%>
            <%--<form:option value="Italy" label="Italy"/>--%>

            <%-- USING LINKEDHASHMAP IN STUDENT class --%>
            <form:options items="${student.countryOptions}" />

        </form:select>

        <br><br>

        Favorite Language:
        <br>
        Java <form:radiobutton path="favoriteLanguage" value="Java" />
        C# <form:radiobutton path="favoriteLanguage" value="C#" />
        PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
        Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

        <br><br>

        Operating System:
        <br>
        Linux <form:checkbox path="operatingSystem" value="Linux" />
        Mac OS <form:checkbox path="operatingSystem" value="Mac OS" />
        MS Windows <form:checkbox path="operatingSystem" value="MS Windows" />

        <br><br>

        <%-- When we call submit button, Spring MVC will call student.setFirstName() etc. --%>
        <input type="submit" value="Submit">

    </form:form>

</body>
</html>
