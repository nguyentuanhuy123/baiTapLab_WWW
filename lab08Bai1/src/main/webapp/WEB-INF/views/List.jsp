<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Employee List</title>

</head>
<body>
    <h2>Employee List</h2>
    <a href="${pageContext.request.contextPath}/show-form">Add</a>
    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Date Of Birth</th>
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
                    <td>${e.dob}</td>
                    <td>${e.email}</td>
                    <td>${e.phone}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit?id=${e.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/delete?id=${e.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>