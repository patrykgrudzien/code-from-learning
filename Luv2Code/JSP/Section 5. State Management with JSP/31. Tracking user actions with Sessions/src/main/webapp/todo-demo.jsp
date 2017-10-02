<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODO List</title>
</head>
<body>

    <%-- Step 1: Create HTML form --%>
    <form action="todo-demo.jsp">  <%-- THIS PAGE WILL SUBMIT DATA TO ITSELF !!! --%>

        Add new item: <input type="text" name="theItem">
        <input type="submit" value="Submit">

    </form>

    <%-- Step 2: Add new item to "To Do" list --%>
    <%
        // get the TO DO items from the session


        // if the TO DO items doesn't exist, then create a new one


        // see if there is form data to add
    %>

    <%-- Step 3: Display all "To Do" items from session --%>

</body>
</html>
