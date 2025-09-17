<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>User Registration Form</title>
</head>
<body>
<h2>User Registration Form</h2>
<form action="register" method="post">

  First Name: <label>
  <input type="text" name="firstName">
</label>
  Last Name: <label>
  <input type="text" name="lastName">
</label><br><br>


  Email: <label>
  <input type="email" name="email">
</label><br><br>
  Re-enter Email: <label>
  <input type="email" name="email2">
</label><br><br>


  Password: <label>
  <input type="password" name="password">
</label><br><br>


  Birthday:
  <label>
    <select name="month">
      <option value="">Month</option>
      <option>January</option><option>February</option><option>March</option>
      <option>April</option><option>May</option><option>June</option>
      <option>July</option><option>August</option><option>September</option>
      <option>October</option><option>November</option><option>December</option>
    </select>
  </label>
  <label>
    <select name="day">
      <option value="">Day</option>
      <% for (int d = 1; d <= 31; d++) { %>
      <option><%= d %></option>
      <% } %>
    </select>
  </label>
  <label>
    <select name="year">
      <option value="">Year</option>
      <% int currentYear = java.time.Year.now().getValue();
        for (int y = currentYear; y >= 1900; y--) { %>
      <option><%= y %></option>
      <% } %>
    </select>
  </label>
  <br><br>


  Gender:
  <label>
    <input type="radio" name="gender" value="female">
  </label> Female
  <label>
    <input type="radio" name="gender" value="male">
  </label> Male
  <br><br>


  <input type="submit" value="Sign Up">
</form>
</body>
</html>
