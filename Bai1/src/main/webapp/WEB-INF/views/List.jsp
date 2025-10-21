<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Employee List</title>
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

        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
            padding: 20px 30px;
        }

        .add-btn {
            display: inline-block;
            background-color: #28a745;
            color: #fff;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 5px;
            margin-bottom: 15px;
            transition: background-color 0.25s;
        }

        .add-btn:hover {
            background-color: #1e7e34;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            text-align: left;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
            text-align: center;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        td {
            color: #333;
        }

        .actions a {
            text-decoration: none;
            font-weight: bold;
            padding: 4px 8px;
            border-radius: 4px;
            margin: 0 2px;
            transition: 0.2s;
        }

        .actions a.edit {
            background-color: #ffc107;
            color: #212529;
        }

        .actions a.edit:hover {
            background-color: #e0a800;
        }

        .actions a.delete {
            background-color: #dc3545;
            color: white;
        }

        .actions a.delete:hover {
            background-color: #b21f2d;
        }
    </style>
</head>
<body>
<h2>EMPLOYEE LIST</h2>

<div class="container">
    <a href="${pageContext.request.contextPath}/show-form" class="add-btn">+ Add Employee</a>
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${employees}">
            <tr>
                <td>${e.firstName}</td>
                <td>${e.lastName}</td>
                <td>${e.gender}</td>
                <td><c:out value="${e.dob}"/></td>
                <td>${e.email}</td>
                <td>${e.phone}</td>
                <td class="actions">
                    <a href="${pageContext.request.contextPath}/edit?id=${e.id}" class="edit">Edit</a>
                    <a href="${pageContext.request.contextPath}/delete?id=${e.id}"
                       class="delete"
                       onclick="return confirm('Delete this employee?');">Delete</a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty employees}">
            <tr>
                <td colspan="7" style="text-align:center; color:#777; padding:15px;">
                    No employees found.
                </td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

</body>
</html>
