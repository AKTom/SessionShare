<%--
  Created by IntelliJ IDEA.
  User: yuyufeng
  Date: 2017/9/15
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<table>
    <h3>用户登录</h3>
    <form action="/loginServlet" method="post">
        <tr>
            <th>用户名:</th>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <th>密码:</th>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </form>
</table>
</body>
</html>
