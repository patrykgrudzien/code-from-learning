<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Auto-Complete</title>

    <link rel="stylesheet" href="<c:url value="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"/>">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

    <script type="text/javascript">

        $(function () {
            $("#tagsName").autocomplete({
                source: function (request, response) {
                    $.getJSON("${pageContext.request.contextPath}/getMatchedNames.web", {term: request.term}, response);
                }
            });
        });

    </script>

</head>
<body>

    <form:form method="get" action="">
        <h1>${message}</h1>
        Enter Name: <input type="text" id="tagsName">
    </form:form>

</body>
</html>
