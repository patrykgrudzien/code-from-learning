<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>

    <%
        // read form data
        final String favoriteLanguage = request.getParameter("favoriteLanguage");

        // create the cookie
        final Cookie cookie = new Cookie("myApp.favoriteLanguage", favoriteLanguage);

        // set the life span... total numer of seconds
        cookie.setMaxAge(60 * 60 * 24 * 365);

        // send cookie to browser
        response.addCookie(cookie);
    %>

</head>
<body>

    Thanks! We set your favorite language to: <%= favoriteLanguage %>

    <br><br>

    <a href="cookies-homepage.jsp">Return to homepage.</a>

</body>
</html>
