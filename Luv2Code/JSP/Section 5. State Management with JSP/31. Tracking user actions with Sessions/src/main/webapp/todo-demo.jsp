<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
        List<String> myToDoList = (List<String>) session.getAttribute("myToDoList");

        // if the TO DO items doesn't exist, then create a new one
        if (myToDoList == null) {
            myToDoList = new ArrayList<>();
            session.setAttribute("myToDoList", myToDoList);
        }

        // see if there is form data to add
        final String theItem = request.getParameter("theItem");
        if (theItem != null) {
            myToDoList.add(theItem);
        }
    %>

    <%-- Step 3: Display all "To Do" items from session --%>
    <hr>
    <b>To List Items:</b>
    <br>

    <ol>
        <%
            for (final String item : myToDoList) {
            	out.println("<li>" + item + "</li>");
            }
        %>
    </ol>

</body>
</html>
