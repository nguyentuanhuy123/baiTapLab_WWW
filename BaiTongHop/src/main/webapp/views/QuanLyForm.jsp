<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/21/2025
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Quản lý điện thoại</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container{
            max-width: 1100px;
            margin: 0 auto;
        }
        .toolbar{
            margin-bottom: 12px;
            display:flex;
            gap:8px;
            align-items:center;
        }
        table{
            width:100%;
            border-collapse: collapse;
            table-layout: auto;
        }
        th, td{
            padding:8px 10px;
            border:1px solid #ccc;
            text-align:left;
            white-space: nowrap;
        }
        th{
            background:#f4f4f4;
        }
        tr:nth-child(even){ background:#fafafa; }
        .msg { padding:8px; margin-bottom:12px; border-radius:4px; }
        .msg.success { background:#e6ffed; color:#14662b; border:1px solid #b8f0c6; }
        .msg.error { background:#ffecec; color:#a10b0b; border:1px solid #f5c2c2; }
        .btn { padding:6px 10px; border-radius:4px; text-decoration:none; display:inline-block; cursor:pointer; }
        .btn.delete { background:#ff6b6b; color:white; border:none; }
        .btn.view { background:#2d9cdb; color:white; border:none; }
        .search-input { padding:6px; width:320px; }
    </style>
    <script>
        function confirmDelete(form) {
            if (confirm('Bạn có chắc muốn xóa bản ghi này không?')) {
                form.submit();
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h2>Quản lý điện thoại</h2>

    <div class="toolbar">
        <form action="${pageContext.request.contextPath}/quanly" method="get" style="display:inline;">
            <input type="text" name="kw" class="search-input" placeholder="Tìm kiếm (maDt, tenDt, ...)" value="${param.kw != null ? param.kw : ''}">
            <button type="submit" class="btn">Tìm</button>
            <a href="${pageContext.request.contextPath}/dt-form" class="btn">Thêm mới</a>
        </form>
    </div>

    <c:if test="${not empty message}">
        <div class="msg success">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="msg error">${error}</div>
    </c:if>
    <div style="flex: 1;display:flex; justify-content:center; align-items:flex-start;">
        <table >
            <thead>
            <tr>
                <th>MADT</th>
                <th>TENDT</th>
                <th>NĂM SX</th>
                <th>CAUHINH</th>
                <th>NHÀ CUNG CẤP</th>
                <th>HÌNH ẢNH</th>
                <th>HÀNH ĐỘNG</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dt" items="${dienThoais}">
                <tr>
                    <td>${dt.maDt}</td>
                    <td>${dt.tenDt}</td>
                    <td>${dt.namSanXuat}</td>
                    <td title="${dt.cauHinh}">${fn:escapeXml(dt.cauHinh)}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty dt.ncc}">${dt.ncc.tenNhaNcc}</c:when>
                            <c:otherwise>-</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty dt.hinhAnh}">
                                <img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}" alt="${dt.tenDt}" style="max-height:40px;">
                            </c:when>
                            <c:otherwise>-</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a class="btn view" href="${pageContext.request.contextPath}/dt-form?maDt=${dt.maDt}">Sửa</a>

                        <form action="${pageContext.request.contextPath}/quanly" method="post" style="display:inline;" onsubmit="event.preventDefault(); confirmDelete(this);">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="maDt" value="${dt.maDt}"/>
                            <button type="submit" class="btn delete">Xóa</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty dienThoais}">
                <tr>
                    <td colspan="7">Không có bản ghi nào.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
<%@ include file="footer.jsp" %>