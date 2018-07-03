<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

    <i>Fill out the form. Asterisk (*) means required.</i>

    <br><br>

    <form:form action="processForm" modelAttribute="customer">

        First name: <form:input path="firstName"/>

        <br><br>

        Last name (*): <form:input path="lastName"/>
        <%-- we add here form:errors for LASTNAME cause in Customer.java we added validation annotations on lastName field --%>
        <form:errors path="lastName" cssClass="error"/>

        <br><br>

        Free passes (*): <form:input path="freePasses"/>
        <form:errors path="freePasses" cssClass="error"/>

        <br><br>

        Postal Code: <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="error"/>

        <br><br>

        <%-- When we press SUBMIT button, we invoke SETTERS on "path" attributes: firstName & lastName --%>
        <%-- Later on we SEND "customer" as modelAttribute to action "processForm" which is method in Controller --%>
        <input type="submit" value="Submit">

    </form:form>
</body>
</html>
