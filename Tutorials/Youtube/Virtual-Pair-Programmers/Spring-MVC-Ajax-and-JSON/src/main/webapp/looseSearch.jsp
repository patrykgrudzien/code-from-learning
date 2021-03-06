<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loose Search</title>

    <%--suppress CheckEmptyScriptTag --%>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <script type="text/javascript">
        function doSearch() {
            // make request to server
            $.getJSON(
                "performLooseSearch",
                {CHARS : $('#searchBox').val()},
                function (data) {
                    // the CALLBACK
                    $('#results').text('');

                    data.forEach(book => {
                        $('#results').append('<p>' + book.title + '</p>');
                    });
                }
            );
        }
    </script>

</head>
<body>

    <h1>Loose Search</h1>

    <input type="text" id="searchBox" onkeyup="doSearch();">

    <div id="results">
        Results will appear here...
    </div>

</body>
</html>
