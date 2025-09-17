<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>Danh sách tài khoản đã đăng ký</h2>

<c:if test="${not empty message}">
    <p style="color:green;">${message}</p>
</c:if>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>Gender</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.email}</td>
            <td>${u.birthday}</td>
            <td>${u.gender}</td>
        </tr>
    </c:forEach>

</table>
<br/>
<a href="index.jsp">⬅ Quay về trang đăng ký</a>
</body>
</html>
