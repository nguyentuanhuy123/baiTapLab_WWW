<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2025
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
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
<form action="${pageContext.request.contextPath}/ncc" method="get">
    <input type="text" name="kw" placeholder="Nhap ma, ten, dia chi hoac sdt cua nha cung cap...">
    <button type="submit"> Tim Kiem</button>
</form>
<div style="flex: 1">
    <table>
        <thead>
        <tr>
            <th>MANCC</th>
            <th>TENNHACC</th>
            <th>DIACHI</th>
            <th>SODIENTHOAI</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tt" items="${nhaCungCaps}">
            <tr>
                <td>${tt.maNcc}</td>
                <td>${tt.tenNhaNcc}</td>
                <td>${tt.diaChi}</td>
                <td>${tt.soDienThoai}</td>
                <td><a href="${pageContext.request.contextPath}/dienthoai?mancc=${tt.maNcc}">Chi tiết</a></td>
            </tr>
        </c:forEach>

        </tbody>

    </table>
</div>


</body>
</html>
<%@ include file="footer.jsp" %>