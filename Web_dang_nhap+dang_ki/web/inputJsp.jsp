<%-- 
    Document   : inputJsp
    Created on : Oct 27, 2023, 9:13:48 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .login{
            text-align: center;
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
    <title>Document</title>
</head>
<body>
    <br>
    <br>
    <form action="inputPage" method="post" class="login">
        <h1>ĐĂNG NHẬP</h1>
        Tên đăng nhập <input type="text" name = "username">
        <br>
        <br>
        Mật khẩu <input type="password" name ="password">
        <br>
        <br>
        <br>
        <input type="submit" value="Đăng nhập">
        <br>
        <br>
        <%
            String a = (String)request.getAttribute("notification");
            if(a != null) out.println(a);
        %>
        <br>
        <br>
        <a href="registerPage.jsp">Chưa có tài khoản ? Đăng kí tại đây</a>
    </form>
</body>
</html>
