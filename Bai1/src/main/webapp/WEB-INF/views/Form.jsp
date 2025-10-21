<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 30px;
        }

        table {
            margin: 30px auto;
            border-collapse: collapse;
            background-color: #fff;
            width: 480px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }

        td {
            padding: 10px 15px;
        }

        td:first-child {
            text-align: right;
            font-weight: bold;
            color: #444;
            width: 150px;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="tel"] {
            width: 90%;
            padding: 6px 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .error {
            color: #d93025;
            font-size: 0.9em;
            display: block;
            margin-top: 3px;
        }

        .actions {
            text-align: center;
            padding: 15px;
        }

        input[type="submit"] {
            background-color: #007bff;
            border: none;
            color: white;
            padding: 8px 16px;
            font-size: 14px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.25s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        a {
            text-decoration: none;
            color: #555;
            margin-left: 10px;
            font-weight: bold;
        }

        a:hover {
            color: #000;
        }

        .gender-label {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<h2>EMPLOYEE FORM</h2>
<%--@elvariable id="employee" type="java"--%>
<form:form modelAttribute="employee" action="${pageContext.request.contextPath}/save" method="post">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>First Name:</td>
            <td>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <form:input path="email"/>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Date of Birth:</td>
            <td>
                <form:input path="dob" type="date"/>
                <form:errors path="dob" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td>
                <form:input path="phone"/>
                <form:errors path="phone" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <label class="gender-label"><form:radiobutton path="gender" value="Male"/> Male</label>
                <label class="gender-label"><form:radiobutton path="gender" value="Female"/> Female</label>
                <form:errors path="gender" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="actions">
                <input type="submit" value="Save"/>
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
