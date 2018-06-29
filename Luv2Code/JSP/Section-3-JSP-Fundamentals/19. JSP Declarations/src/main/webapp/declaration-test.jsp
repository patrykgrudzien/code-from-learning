<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Declarations Test</title>
</head>
<body>

    <%!
        private String makeItLower(final String data)
        {
            return data.toLowerCase();
        }
    %>

    Lower case "Hello World" : <%= makeItLower("Hello World") %>

</body>
</html>
