<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriplets Test</title>
</head>
<body>

    <h3>Hello World of Java!</h3>

    <%
        for (int i = 1; i <= 5; i++)
        {
            // --- WE DO NOT USE "System" BECAUSE "System" PRINTS TO CONSOLE, NOT IN BROWSER!!! ---
            out.println("<br/>I really luv2code: " + i);
        }
    %>

</body>
</html>
