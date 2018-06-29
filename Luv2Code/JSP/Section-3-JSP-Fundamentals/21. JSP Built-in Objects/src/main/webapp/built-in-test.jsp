<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Built-in Test</title>
</head>
<body>

    <h3 align="center">JSP Built-in Objects</h3>

    Request user agent: <%= request.getHeader("User-Agent") %>

    <br/><br/>

    Request language: <%= request.getLocale() %>

</body>
</html>
