<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/views/header.jsp" %>

<div class="content-area">
  <div class="content-box">
    <h2>Danh sách tin tức</h2>

    <table class="table-list">
      <thead>
      <tr>
        <th>Mã TT</th>
        <th>Tiêu đề</th>
        <th>Nội dung</th>
        <th>Liên kết</th>
        <th>Mã DM</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="tt" items="${tinTucList}">
        <tr>
          <td>${tt.maTT}</td>
          <td>${tt.tieuDe}</td>
          <td>${tt.noiDungTT}</td>
          <td><a href="${tt.lienKet}" target="_blank">Xem</a></td>
          <td>${tt.danhMuc.maDM}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>
</div>

<%@ include file="/views/footer.jsp" %>
