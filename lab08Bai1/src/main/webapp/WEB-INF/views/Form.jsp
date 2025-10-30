<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Employee Form</title>

</head>
<body>
<h2>Registration Employee</h2>
<%--@elvariable id="employee" type="jave"--%>
<form:form modelAttribute="employee" action="${pageContext.request.contextPath}/save" method="post">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>First Name</td>
            <td>
                <form:input path="firstName"/>
                <form:errors path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>
                <form:input path="lastName"/>
                <form:errors path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <form:input path="email"/>
                <form:errors path="email"/>
            </td>
        </tr>
        <tr>
            <td>Date Of Birth</td>
            <td>
                <form:input path="dob" type="date"/>
                <form:errors path="dob"/>
            </td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td>
                <form:input path="phone"/>
                <form:errors path="phone"/>
            </td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <form:radiobutton path="gender" value="Male"/>Male
                <form:radiobutton path="gender" value="Female"/>Female
                <form:errors path="gender"/>
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