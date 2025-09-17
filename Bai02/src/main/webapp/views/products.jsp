<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách sản phẩm</title>
  <style>
    body { font-family: Arial, sans-serif; }
    .top-link { margin: 10px; display: block; }
    .catalog { display: flex; gap: 20px; padding: 20px; flex-wrap: wrap; }
    .card {
      width: 200px;
      border: 1px solid #333;
      padding: 10px;
      text-align: center;
    }
    .card img { width: 120px; height: 120px; object-fit: contain; }
    .price { margin: 5px 0; font-weight: bold; }
    .qty { width: 50px; }
  </style>
</head>
<body>

<a class="top-link" href="${pageContext.request.contextPath}/cart">Xem giỏ hàng</a>

<div class="catalog">
  <c:forEach var="p" items="${products}">
    <div class="card">
      <h3>${p.name}</h3>
      <img src="${p.image}" alt="${p.name}">
      <div class="price">Giá: ${p.price}</div>

      <form action="${pageContext.request.contextPath}/cart" method="post">
        <input type="hidden" name="action" value="buy" />
        <input type="hidden" name="id" value="${p.id}" />
        SL: <input type="number" name="quantity" value="1" min="1" class="qty" />
        <br><br>
        <input type="submit" value="Thêm vào giỏ">
      </form>
    </div>
  </c:forEach>
</div>

</body>
</html>
