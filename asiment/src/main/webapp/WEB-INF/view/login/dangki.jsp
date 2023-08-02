<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>


</head>
<style>
    form {
        margin: 20px;
        padding: 20px;
        border: 1px solid #ccc;
    }

    label {
        display: inline-block;
        width: 80px;
    }

    input[type="text"],
    input[type="password"] {
        width: 200px;
        padding: 5px;
        margin-bottom: 10px;
    }

    button[type="submit"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }

    button[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
<body>
<form method="POST" action="/dangki-taikhoan" modelAttribute="dangKi">
    <label>Ten:</label>
    <input type="text" name="ten"/>

    <label>SDT:</label>
    <input type="text" name="sdt"/>
    <br>

    <label>Dia chi:</label>
    <input type="text" name="diaChi"/>
    <br>

    <label>Taikhoan:</label>
    <input type="text" name="email"/>
    <br>

    <label>Mat Khau:</label>
    <input type="password" name="matKhau"/>
    <br>
    <%--    <label>Quyen:</label>--%>
    <%--    <input type="radio" name="1" value="1" /> KhachHang--%>

    <button type="submit">Dang ki tai khoan</button>
</form>

</body>
</html>