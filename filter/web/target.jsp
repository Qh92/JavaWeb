<%--
  Created by IntelliJ IDEA.
  User: Qh
  Date: 2021/10/31
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("target.jsp页面执行了");
        System.out.println("target.jsp的线程名: " + Thread.currentThread().getName());
    %>

</body>
</html>
