<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-Ab+WxLv0oU31V6U2q3+1Q8W+Mf5v5Bww02hj5Ofbl8W27kNEdvGj/7J/9E1G7Jws+YaAkyJlw7jAK++CsgqnkA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!------ Include the above in your HEAD tag ---------->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css">
</head>
<body>
<c:if test="${not empty successMessage}">
    <div class="alert alert-success">
        <center>
                ${successMessage}
        </center>
    </div>
</c:if>
<div class="container">
    <center>
        Hóa đơn của : ${khachHang.ten}
    </center>
    <br>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Đơn giá</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="totalPrice" value="0"/>
        <c:forEach items="${hoaDonChiTiets}" var="gh">
            <tr>
                <td>${gh.idChiTietSanPham.idSP.ten}</td>
                <td>${gh.soLuong}</td>
                <td>${gh.donGia}</td>
            </tr>
            <c:set var="totalPrice" value="${totalPrice + gh.donGia}"/>
        </c:forEach>
        </tbody>
    </table>
    <center>
        Tổng thanh toán : ${totalPrice} VND
    </center>
</div>

</body>
</html>
