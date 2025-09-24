<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Thêm Điện Thoại</title>
    <meta charset="UTF-8"/>
    <style>
        label { display:block; margin-top:8px; }
        .error { color: red; }
        .form-control { width: 400px; padding:6px; }
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
    </style>
</head>
<body>
<h2>Thêm Điện Thoại</h2>

<c:if test="${not empty errors}">
    <div class="error">
        <ul>
            <c:forEach var="entry" items="${errors}">
                <li><c:out value="${entry.key}"/> : <c:out value="${entry.value}"/></li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/dt-form" enctype="multipart/form-data" style="flex: 1;display:flex; justify-content:center;flex-direction: column;">
    <label for="maDt">Mã ĐT *</label>
    <input class="form-control" type="text" id="maDt" name="maDt" value="${maDt != null ? maDt : ''}" />

    <label for="tenDt">Tên điện thoại *</label>
    <input class="form-control" type="text" id="tenDt" name="tenDt" value="${tenDt != null ? tenDt : ''}" />

    <label for="namSanXuat">Năm sản xuất (4 chữ số) *</label>
    <input class="form-control" type="text" id="namSanXuat" name="namSanXuat"
           value="${namSanXuat != null ? namSanXuat : ''}" />

    <label for="cauHinh">Thông tin cấu hình (max 255 ký tự) *</label>
    <textarea class="form-control" id="cauHinh" name="cauHinh" rows="4" maxlength="255">${cauHinh != null ? cauHinh : ''}</textarea>

    <label for="mancc">Nhà cung cấp</label>
    <select class="form-control" id="mancc" name="mancc">
        <option value="">-- Chọn nhà cung cấp --</option>
        <c:forEach var="n" items="${nhaCungCaps}">
            <option value="${n.maNcc}" ${n.maNcc == mancc ? 'selected="selected"' : ''}>${n.tenNhaNcc} (${n.maNcc})</option>
        </c:forEach>
    </select>

    <label for="hinhAnh">Hình ảnh (png, jpg, jpeg)</label>
    <input class="form-control" type="file" id="hinhAnh" name="hinhAnh" accept=".png,.jpg,.jpeg"/>

    <br/>
    <button type="submit">Thêm</button>
    <button type="reset">Làm lại</button>
</form>

</body>
</html>
<%@ include file="footer.jsp" %>