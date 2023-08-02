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
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Đơn giá</th>
        <th scope="col">Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="totalPrice" value="0"/>
    <c:forEach items="${gioHangChiTiets}" var="gh">
        <tr>
            <td>${gh.idChiTietSanPham.idSP.ten}</td>
            <td>${gh.soLuong}</td>
            <td>${gh.donGia}</td>
            <td>
                <div class="row">
                    <div class="col-2">
                        <form action="/gio-hang/add-to-cart/${gh.idChiTietSanPham.id}" method="post">
                            <div class="mb-3">
                                <input type="hidden" name="action" value="increase">
                                <input type="hidden" name="userId" value="${user.id}"/>
                                <button type="submit" class="btn btn-secondary">+</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-2">
                        <form action="/gio-hang/xoa-san-pham/${gh.idChiTietSanPham.id}" method="post">
                            <button type="submit" class="btn btn-danger">
                                <input type="hidden" name="userId" value="${user.id}"/>
                                <i class="bi bi-trash"></i> <!-- Icon thùng giác -->
                            </button>
                        </form>
                    </div>
                    <div class="col-2">
                        <form action="/gio-hang/tru-san-pham/${gh.idChiTietSanPham.id}" method="post">
                            <div class="mb-3">
                                <input type="hidden" name="action" value="increase">
                                <input type="hidden" name="userId" value="${user.id}"/>
                                <button type="submit" class="btn btn-secondary">-</button>
                            </div>
                        </form>
                    </div>
                </div>
            </td>
        </tr>
        <c:set var="totalPrice" value="${totalPrice + gh.donGia}"/>
    </c:forEach>
    </tbody>
</table>
<tr>

</tr>
<center>
    <form action="/hoa-don/tao-hoa-don/${gioHang.id}" method="post">
        <td colspan="3">Tổng giá trị:</td>
        <input type="hidden" name="totalPrice" value="${totalPrice}"/>${totalPrice} VND
        <input type="hidden" name="userId" value="${user.id}"/>
        <br>
        <br>
        <button type="submit" class="btn btn-primary">Thanh toán</button>
    </form>
    <br>
    <a type="button" class="btn btn-primary" href="/checkLogin">Quay lại</a>
</center>

</body>
</html>
