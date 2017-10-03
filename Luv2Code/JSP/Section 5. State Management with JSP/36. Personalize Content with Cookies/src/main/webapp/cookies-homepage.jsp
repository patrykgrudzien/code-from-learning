<html>
<head>
    <title>Homepage</title>
</head>
<body>

    <h3>Training Portal</h3>

    <%-- read the favorite programming langiage cookie --%>
    <%
        // the default... if there are no cookies
        String favouriteLanguage = "Java";

        // get the cookies from the browser
        final Cookie[] cookies = request.getCookies();

        // find our favorite language cookie
        if (cookies != null) {
            for (final Cookie tempCookie : cookies) {
                if ("myApp.favoriteLanguage".equals(tempCookie.getName())) {
                    favouriteLanguage = tempCookie.getValue();
                    break;
                }
            }
        }
    %>

    <%-- now show a personalized page... use the 'favouriteLanguage' variable --%>
    <h4>New Books for <%= favouriteLanguage %></h4>
    <ul>
        <li>blah blah blah</li>
        <li>blah blah blah</li>
    </ul>

    <h4>New Books for <%= favouriteLanguage %></h4>
    <ul>
        <li>blah blah blah</li>
        <li>blah blah blah</li>
    </ul>

    <h4>Latest News Reports for <%= favouriteLanguage %></h4>
    <ul>
        <li>blah blah blah</li>
        <li>blah blah blah</li>
    </ul>

    <hr>

    <a href="cookies-personalize-form.html">Personalize this page</a>

</body>
</html>