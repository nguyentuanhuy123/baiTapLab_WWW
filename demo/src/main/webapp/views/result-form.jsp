<%@ page import="iuh.fit.se.models.Student" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Student student = (Student) request.getAttribute("student");
    %>
    <h2>Registration Result</h2>
    <p>First name: <%= student.getFName() %></p>
    <p>Last name: <%= student.getLName() %></p>
    <p>Gender: <%= student.getGender() %></p>
    <p>Email: <%= student.getEmail() %></p>
    <p>Birthday: <%= student.getBDay() %></p>
</body>
</html>
