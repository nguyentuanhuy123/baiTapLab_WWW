<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2025
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        body{
            display: flex;
            justify-content: center;
            align-content: center;
            min-height: 100vh;
        }
        table{
            text-align: center;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            width: auto;
            table-layout: auto;

        }
        th, td {
            border: 1px solid #333;
            white-space: nowrap;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #fafafa;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>MADT</th>
        <th>TENDT</th>
        <th>NAMSANXUAT</th>
        <th>CAUHINH</th>
        <th>MANCC</th>
        <th>HINHANH</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tt" items="${dienThoais}">
        <tr>
            <td>${tt.maDt}</td>
            <td>${tt.tenDt}</td>
            <td>${tt.namSanXuat}</td>
            <td>${tt.cauHinh}</td>
            <td>${tt.ncc.getMaNcc()}</td>
            <td><img src="${pageContext.request.contextPath}/images/${tt.hinhAnh}"
                     alt="${tt.tenDt}"
                     width="100" height="100"/>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

</body>
</html>