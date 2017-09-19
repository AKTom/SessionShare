<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/9/15
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
    <body>
        <h3>登录用户:${SESSION_USER.username}</h3>
        <p><a href="/quitServlet">退出</a></p>
        <p><a href="/loginServlet">登录</a></p>

    </body>
</html>
