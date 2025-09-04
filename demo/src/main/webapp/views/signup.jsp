<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="registration-form" name="formDangKy" method="GET" style="background-color: cadetblue;padding: 20px;color: white">
      <label style="display: inline-block; width: 150px;" for="txtFName">First name:</label>
      <input style="" type="text" id="txtFName" name="txtFName">
      (max 30 character a-z and A-Z)
      <br><br>
      <label style="display: inline-block; width: 150px;" for="txtLName">Last name:</label>
      <input style="" type="text" id="txtLName" name="txtLName">
      (max 30 character a-z and A-Z)
      <br><br>

      <label style="display: inline-block; width: 150px;" for="birthday">Date of birth:</label>
      <input style="" type="date" id="birthday" name="birthday"><br><br>
      <br><br>

      <label style="display: inline-block; width: 150px;" for="txtEmail">Email:</label>
      <input style="" type="text" id="txtEmail" name="txtEmail">
      <br><br>

      <label style="display: inline-block; width: 150px;" for="txtMobileNumber">Mobile number:</label>
      <input style="" type="text" id="txtMobileNumber" name="txtMobileNumber">
      <br><br>

      <label style="display: inline-block; width: 150px;" >Gender:</label>
      <div style="">
          <input type="radio" id="male" name="gender" value="male">
          <label for="male">Male</label>

          <input type="radio" id="female" name="gender" value="female" style="margin-left:20px;">
          <label for="female">Female</label>
      </div>
      <br><br>

      <label style="display: inline-block; width: 150px;" for="txtAddress">Address:</label>
      <textarea id="txtAddress" name="txtAddress" rows="4" cols="50" style="vertical-align: top;"></textarea>
      <br><br>

      <div style="margin-left: 150px;">
          <input type="submit" value="Submit" style="margin-right: 10px;">
          <input type="reset" value="Reset">
      </div>


  </form>
</body>
</html>
