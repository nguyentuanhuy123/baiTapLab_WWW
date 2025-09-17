<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/views/header.jsp" %>

<div class="content-area">
  <div class="content-box">
    <h2>Quản lý tin tức</h2>

    <table class="table-list">
      <thead>
      <tr>
        <th>Mã TT</th>
        <th>Tiêu đề</th>
        <th>Mã DM</th>
        <th>Thao tác</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="tt" items="${tinTucs}">
        <tr>
          <td>${tt.maTT}</td>
          <td>${tt.tieuDe}</td>
          <td>${tt.danhMuc.maDM}</td>
          <td>
            <form method="post" action="${pageContext.request.contextPath}/quan-ly-tin-tuc" onsubmit="return confirmDelete(this);">
              <input type="hidden" name="maTT" value="${tt.maTT}">
              <input type="submit" name="action" value="Xóa">
            </form>
          </td>
        </tr>
      </c:forEach>

      <c:if test="${empty tinTucList}">
        <tr>
          <td colspan="4" style="text-align:center; color:#666;">Không có tin tức</td>
        </tr>
      </c:if>
      </tbody>
    </table>

    <div style="margin-top:12px;">
      <a href="${pageContext.request.contextPath}/them-tin-tuc">Thêm tin tức mới</a>
    </div>
  </div>
</div>

<%@ include file="/views/footer.jsp" %>

