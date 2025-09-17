<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/views/header.jsp" %>

<div class="content-area">
    <div class="content-box">
        <h2>Thêm tin tức mới</h2>
        <c:if test="${not empty error}">
            <div style="color: red; margin-bottom: 15px; font-weight: bold;">
                <c:out value="${error}" escapeXml="false"/>
            </div>
        </c:if>


        <form id="tinTucForm" action="${pageContext.request.contextPath}/them-tin-tuc" method="post" novalidate>
            <div class="form-row">
                <label for="maTT">Mã TT:</label>
                <input type="text" id="maTT" name="maTT" required>
            </div>

            <div class="form-row">
                <label for="tieuDe">Tiêu đề:</label>
                <input type="text" id="tieuDe" name="tieuDe" required>
            </div>

            <div class="form-row">
                <label for="noiDung">Nội dung:</label>
                <textarea id="noiDung" name="noiDung" rows="5" maxlength="255" required></textarea>
                <div style="margin-left:140px; font-size:12px; color:#666;">Tối đa 255 ký tự</div>
            </div>

            <div class="form-row">
                <label for="lienKet">Liên kết:</label>
                <input type="text" id="lienKet" name="lienKet" placeholder="ví dụ: http://example.com/..." required>
                <div id="lienKetError" style="margin-left:140px; color:#b00; font-size:13px; display:none;">Liên kết phải bắt đầu bằng <code>http://</code></div>
            </div>

            <div class="form-row">
                <label for="maDM">Mã DM:</label>
                <select id="maDM" name="maDM" required>
                    <option value="">-- Chọn danh mục --</option>
                    <c:forEach var="dm" items="${danhMucs}">
                        <option value="${dm.maDM}">${dm.tenDanhMuc} (${dm.maDM})</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-row" style="margin-left:140px;">
                <input type="submit" value="Thêm">
                <input type="reset" value="Làm lại" style="margin-left:12px;">
                <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc" style="margin-left:12px;">Quay về danh sách</a>
            </div>
        </form>
    </div>
</div>

<%@ include file="/views/footer.jsp" %>
