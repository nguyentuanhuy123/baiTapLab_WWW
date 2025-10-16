<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<%--@elvariable id="employee" type="java"--%>
<form:form modelAttribute="employee" action="${pageContext.request.contextPath}/save" method="post">
    <table>
        <tr>
            <td>First Name:</td>
            <td>
                <form:input path="firstName"/>
                <form:errors path="firstName"/>
            </td>

        </tr>
        <tr>
            <td>Last Name:</td>
            <td>
                <form:input path="lastName"/>
                <form:errors path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <form:input path="email"/>
                <form:errors path="email"/>
            </td>
        </tr>
        <tr>
            <td>Date of Birth:</td>
            <td>
                <form:input path="dob" type="date"/>
                <form:errors path="dob"/>
            </td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td>
                <form:input path="phone"/>
                <form:errors path="phone"/>
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <form:radiobutton path="gender" value="Male" /> Male
                <form:radiobutton path="gender" value="Female" /> Female
                <form:errors path="gender" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>