<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/28/2025
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Multi Files</title>
</head>
<body>
<h2>Upload multi-files</h2>
<form method="post" action="upload" enctype="multipart/form-data">
    File #1: <input type="file" name="file"><br>
    File #2: <input type="file" name="file"><br>
    File #3: <input type="file" name="file"><br>
    File #4: <input type="file" name="file"><br>
    File #5: <input type="file" name="file"><br>
    <input type="submit" value="Upload">
    <input type="reset" value="Reset">
</form>
</body>
</html>
