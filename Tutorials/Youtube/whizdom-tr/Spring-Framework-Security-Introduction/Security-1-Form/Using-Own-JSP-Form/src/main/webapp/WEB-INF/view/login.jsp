<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Login Page</title>

    <style>
        .errorBlock
        {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>

<body onload="document.my_form.j_username.focus();" bgcolor="blue">
    <h3>Login with Username and Password (Custom Page)</h3>

    <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}"> <!-- NOT EMPTY ERROR -->
        <div class="errorBlock">
            Your login attempt was not successful, try again.
            <br/>
            Caused by: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>

    <form name="my_form" action="<c:url value="j_spring_security_check"/>" method="post">
        <table>
            <tr>
                <td>User:</td>
                <td>
                    <input type="text" name="j_username" value="" />
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <input type="password" name="j_password" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input name="Submit" type="submit" value="Submit">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="reset" name="reset">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
