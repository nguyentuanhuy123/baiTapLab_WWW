<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Giỏ hàng</title>
  <style>
    body { font-family: Arial, sans-serif; }
    table.cart { width: 100%; border-collapse: collapse; margin-top: 12px; }
    table.cart th, table.cart td { border: 1px solid #999; padding: 8px; vertical-align: top; }
    table.cart th { background: #ddd; text-align: left; }
    .qty-input { width: 60px; }
    .right { text-align: right; }
    .subtotal-cell { text-align: right; font-weight: bold; padding-right: 12px; }
    .success { color: green; font-weight: bold; margin: 10px 0; }
  </style>
</head>
<body>
<h2>Giỏ hàng của bạn</h2>

<c:if test="${checkoutSuccess}">
  <p class="success">Thanh toán thành công!</p>
  <p><a href="${pageContext.request.contextPath}/products">Tiếp tục mua hàng</a></p>
</c:if>
<c:if test="${!checkoutSuccess}">
  <c:choose>
    <c:when test="${empty sessionScope.cart}">
      <p>Giỏ hàng trống.</p>
      <p><a href="${pageContext.request.contextPath}/products">Tiếp tục mua hàng</a></p>
    </c:when>
    <c:otherwise>
      <table class="cart">
        <tr>
          <th>Model Description</th>
          <th>Quantity</th>
          <th class="right">Unit Price</th>
          <th class="right">Total</th>
        </tr>

        <c:set var="subtotal" value="${0.0}" scope="page" />

        <c:forEach var="item" items="${sessionScope.cart}">
          <c:set var="prod" value="${item.product}" />
          <c:set var="lineTotal" value="${prod.price * item.quantity}" />

          <tr>
            <td>
              <div><strong>${prod.id}</strong></div>
              <div>${prod.name}</div>
            </td>

            <td>
              <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
                <input type="hidden" name="action" value="update" />
                <input type="hidden" name="id" value="${prod.id}" />
                <input type="number" name="quantity" value="${item.quantity}" min="0" class="qty-input" />
                <input type="submit" value="Update" />
              </form>
              <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline; margin-left:8px;">
                <input type="hidden" name="action" value="remove" />
                <input type="hidden" name="id" value="${prod.id}" />
                <input type="submit" value="Delete" />
              </form>
            </td>

            <td class="right">
              <fmt:formatNumber value="${prod.price}" type="number" maxFractionDigits="0" />
            </td>

            <td class="right">
              <fmt:formatNumber value="${lineTotal}" type="number" maxFractionDigits="0" />
            </td>
          </tr>

          <c:set var="subtotal" value="${subtotal + lineTotal}" scope="page" />
        </c:forEach>

        <tr>
          <td colspan="3" class="subtotal-cell">Subtotal:</td>
          <td class="right">
            <fmt:formatNumber value="${subtotal}" type="number" maxFractionDigits="0" />
          </td>
        </tr>
      </table>

      <br/>
      <a href="${pageContext.request.contextPath}/products">Tiếp tục mua hàng</a>
      &nbsp;&nbsp;
      <form action="${pageContext.request.contextPath}/cart" method="post" style="display:inline;">
        <input type="hidden" name="action" value="checkout" />
        <input type="submit" value="Thanh toán" />
      </form>
    </c:otherwise>
  </c:choose>
</c:if>

</body>
</html>
