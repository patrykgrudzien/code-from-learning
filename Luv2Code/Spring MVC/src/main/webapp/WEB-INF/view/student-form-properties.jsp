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
            <%--<form:options items="${student.countryOptions}" />--%>

            <%-- USING PROPERTIES FILE --%>
            <form:options items="${theCountryOptions}" />

        </form:select>

        <br><br>

        <%-- When we call submit button, Spring MVC will call student.setFirstName() etc. --%>
        <input type="submit" value="Submit">

    </form:form>

</body>
</html>
