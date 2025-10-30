<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm điện thoại</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: 0;
            min-height: 100vh;
        }
        main {
            flex: 1;
            padding-top: 20px;
        }
        select, input, textarea {
            width: 500px;
            min-height: 30px;
            border: 1px solid gray;
            border-radius: 6px 8px;
        }
        form {
            flex: 1;
            flex-direction: column;
            display: flex;
            gap: 10px;
        }
        .error {
            color: red;
            font-size: 13px;
        }
    </style>
    <jsp:include page="header.jsp"/>
</head>
<body>
<main>
    <h2>Thêm Sản Phẩm</h2>

    <!-- form:form liên kết với modelAttribute="dienthoai" trong controller -->
    <%--@elvariable id="dienthoai" type="java"--%>
    <form:form modelAttribute="dienthoai"
               method="post"
               action="${pageContext.request.contextPath}/dt-form"
               enctype="multipart/form-data">

        <label>Mã ĐT:</label>
        <form:input path="maDt" id="maDt"/>
        <form:errors path="maDt" cssClass="error"/>

        <label>Tên điện thoại:</label>
        <form:input path="tenDt" id="tenDt"/>
        <form:errors path="tenDt" cssClass="error"/>

        <label>Năm sản xuất:</label>
        <form:input path="namSanXuat" id="namSanXuat"/>
        <form:errors path="namSanXuat" cssClass="error"/>

        <label>Thông tin cấu hình:</label>
        <form:textarea path="cauHinh" id="cauHinh" rows="4"/>
        <form:errors path="cauHinh" cssClass="error"/>

        <label>Nhà cung cấp:</label>
        <form:select path="ncc.maNcc" id="maNcc">
            <form:option value="">-- Chọn Nhà Cung Cấp --</form:option>
            <form:options items="${nccs}" itemValue="maNcc" itemLabel="tenNhaCc"/>
        </form:select>
        <form:errors path="ncc" cssClass="error"/>

        <label>Hình ảnh:</label>
        <input type="file" name="file" id="hinhAnh"/>
        <form:errors path="hinhAnh" cssClass="error"/>

        <div>
            <button type="reset">Reset</button>
            <button type="submit">Submit</button>
        </div>
    </form:form>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>

