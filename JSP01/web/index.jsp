<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP 01</title>
    </head>
    <body>
        <h1>User Details Form</h1>
        <form action="" method="post">
            <input type="text" name="fname" placeholder="First Name">
            <br>
            <input type="text" name="lname" placeholder="Last Name">
            <br>
            <input name="mobileno" type="tel" pattern="[0-9]{10}" placeholder="Mobile No">
            <br>
            <input name="email" type="email" placeholder="Email Id">
            <br>
            <input name="city" type="text" placeholder="City">
            <br>
            <input name="age" type="number" placeholder="Age">
            <br>
            <input type="submit" name="submit" value="Submit">
        </form>

        <% if(request.getParameter("submit") != null) { %>
            <jsp:useBean id="details" class="ml.Details" scope="request"></jsp:useBean>
            <jsp:setProperty name="details" property="*"></jsp:setProperty>
            <jsp:forward page="success"></jsp:forward>
        <% } %>
    </body>
</html>
