<%--
  Created by IntelliJ IDEA.
  User: Qh
  Date: 2021/10/31
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    请登录 <br>
    <form action="http://localhost:8080/filter/loginServlet" method="get">
        用户名: <input type="text" name="username"/><br>
        密码: <input type="text" name="password"/><br>
        <input type="submit">
    </form>


</body>
</html>
