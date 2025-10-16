<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h2>EMPLOYEE LIST</h2>
<a href="${pageContext.request.contextPath}/show-form">Add</a>
<form:form>
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
                    <td>${e.dob}</td>
                    <td>${e.email}</td>
                    <td>${e.phone}</td>
                    <td><a href="${pageContext.request.contextPath}/update?id=${e.id}">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form:form>
</body>
</html>