<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/30/2025
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: 0;
            min-height: 100vh;
        }
        main{
            flex: 1;
            padding-top: 20px;
        }
        select,input{
            width: 500px;
            min-height: 30px;
            border: 1px solid gray;
            border-radius: 6px 8px;
        }
        table{
            margin-top: 20px;
            margin-bottom: 20px;
            width: auto;
            box-shadow: 0 5px 10px gray;
            table-layout: auto;
            border:1px solid black;
            border-collapse: collapse;
        }
        td,th{
            padding: 8px 10px;
            border: 1px solid black;
            white-space: nowrap;
        }
        th{
            background-color: #fafafa;
        }
        td{
            background-color: aliceblue;
        }
        tr:hover{
            background-color: gray;
        }

    </style>
</head>
<body>
<main>
    <h2>Thong Tin NhaCungCap</h2>
    <table>
        <thead>
        <tr>
            <th>MANCC</th>
            <th>TENHACC</th>
            <th>DIACHI</th>
            <th>SODIENTHOAI</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ncc" items="${nccs}">
            <tr>
                <td>${ncc.maNcc}</td>
                <td>${ncc.tenNhaCc}</td>
                <td>${ncc.diaChi}</td>
                <td>${ncc.soDienThoai}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <h2>Thong Tin DienThoai</h2>
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
        <c:forEach var="dt" items="${dts}">
            <tr>
                <th>${dt.maDt}</th>
                <th>${dt.tenDt}</th>
                <th>${dt.namSanXuat}</th>
                <th>${dt.cauHinh}</th>
                <th>${dt.ncc.maNcc}</th>
                <th><img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}" style="width: 50px;height: 50px;object-fit: fill;"></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>
<jsp:include page="footer.jsp"/>