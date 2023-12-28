<%-- 
    Document   : registerPage
    Created on : Oct 27, 2023, 9:25:54 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .register{
            text-align: center;
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
    <title>Document</title>
</head>
<body>
    <br>
    <br>
    <form action="inputPage" method="get" class="register">
        <h1>ĐĂNG KÝ</h1>
        Tên đăng nhập của bạn <input type="text" name ="registerOfUsername" placeholder="Nhập tên tài khoản">
        <br>
        <br>
        Mật khẩu của bạn <input type="password" name="registerOfPassword" placeholder="Nhập mật khẩu">
        <br>
        <br>
        Xác nhận mật khẩu <input type="password" name="registerOfPassword1" placeholder="Nhập lại mật khẩu">
        <br>
        <br>
        <br>
        <input type="submit" value="Ðang kí">
        <br>
        <br>
        <%
            String a = (String)request.getAttribute("notification");
            if(a != null) out.println(a);
            
        %>
    </form>
</body>
</html>
