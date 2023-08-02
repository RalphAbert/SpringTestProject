<%--
  Created by IntelliJ IDEA.
  User: HP probook
  Date: 02/04/2023
  Time: 3:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <style>
        /*
    ** Style Simple Ecommerce Theme for Bootstrap 4
    ** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
    */

        .category_block li:hover {
            background-color: #007bff;
        }

        .category_block li:hover a {
            color: #ffffff;
        }

        .category_block li a {
            color: #343a40;
        }

        .add_to_cart_block .price {
            color: #c01508;
            text-align: center;
            font-weight: bold;
            font-size: 200%;
            margin-bottom: 0;
        }

        .add_to_cart_block .price_discounted {
            color: #343a40;
            text-align: center;
            text-decoration: line-through;
            font-size: 140%;
        }


        .product_rassurance .list-inline {
            margin-bottom: 0;
            text-transform: uppercase;
            text-align: center;
        }

        .product_rassurance .list-inline li:hover {
            color: #343a40;
        }

        .reviews_product .fa-star {
            color: gold;
        }


        footer {
            background: #343a40;
            padding: 40px;
            margin-top: 20px;
        }

        footer a {
            color: #f8f9fa !important
        }

        button a {
            color: white;
        }

        a .active {
            color: white;
        }

    </style>
</head>
<body>
<!--begin of menu-->
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="home">GYM MAX</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/chi-tiet-sp/hien-thi">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/san-pham/hien-thi">Sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/mau-sac/hien-thi">Màu sắc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/nha-san-xuat/hien-thi">NSX</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cua-hang/hien-thi">Cửa hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/khach-hang/hien-thi">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dong-sp/hien-thi">Dòng SP</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/chuc-vu/hien-thi">Chức vụ</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/nhan-vien/hien-thi">Nhân viên</a>
                </li>

            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txt" type="text" class="form-control" aria-label="Small"
                           aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="show">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>


<!-- banner -->
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="../../../img/logo.jpg" class="d-block w-100" alt="..." width="100%" height="60%">
        </div>
        <div class="carousel-item">
            <img src="../../../img/logo.jpg" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<div class="container">
    <form:form class="w3-container" action="/chi-tiet-san-pham/add" method="post" modelAttribute="chiTietSPDTO"
               enctype="multipart/form-data" onsubmit="return confirmAdd()">
        <div class="row">
            <div class="col-6">
                <label class="form-label">Sản phẩm</label>
                <form:select path="idSP.id" class="form-control">
                    <c:forEach items="${listSP}" var="sp">
                        <form:option value="${sp.id}">${sp.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-6">
                <label class="form-label">Màu Sắc</label>
                <form:select path="idMauSac.id" class="form-control">
                    <c:forEach items="${listMS}" var="sp">
                        <form:option value="${sp.id}">${sp.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Dòng sản phẩm</label>
                <form:select path="idDongSP.id" class="form-control">
                    <c:forEach items="${listDSP}" var="sp">
                        <form:option value="${sp.id}">${sp.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-6">
                <label class="form-label">Nhà sản xuất</label>
                <form:select path="idNSX.id" class="form-control">
                    <c:forEach items="${listNSX}" var="sp">
                        <form:option value="${sp.id}">${sp.ten}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Năm bảo hành</label>
                <form:input class="form-control" path="namBH"></form:input>
            </div>
            <div class="col-6">
                <label class="form-label">Số lượng tồn</label>
                <form:input class="form-control" path="soLuongTon"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Cân nặng(kg)</label>
                <form:input class="form-control" path="canNang"></form:input>
            </div>
            <div class="col-6">
                <label class="form-label">Ảnh</label>
                <form:input class="form-control" path="image" type="file"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label class="form-label">Giá nhập</label>
                <form:input class="form-control" path="giaNhap" type="number"></form:input>
            </div>
            <div class="col-6">
                <label class="form-label">Giá bán</label>
                <form:input class="form-control" path="giaBan" type="number"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label class="form-label">Mô tả</label>
                <form:textarea class="form-control" path="moTa"></form:textarea>
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Add</button>
    </form:form>
</div>
<!--end of menu-->

<!-- Footer -->
<footer class="text-light">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 col-lg-4 col-xl-3">
                <h5>About</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <p class="mb-0">
                    Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant
                    impression.
                </p>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                <h5>Informations</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><a href="">Link 1</a></li>
                    <li><a href="">Link 2</a></li>
                    <li><a href="">Link 3</a></li>
                    <li><a href="">Link 4</a></li>
                </ul>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                <h5>Others links</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><a href="">Link 1</a></li>
                    <li><a href="">Link 2</a></li>
                    <li><a href="">Link 3</a></li>
                    <li><a href="">Link 4</a></li>
                </ul>
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3">
                <h5>Contact</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><i class="fa fa-home mr-2"></i> My company</li>
                    <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
                    <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
                    <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                </ul>
            </div>
            <div class="col-12 copyright mt-3">

                <p class="float-left">
                    <a href="#">Back to top</a>
                </p>
                <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a
                        href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> |
                    <span>v. 1.0</span></p>
            </div>
        </div>
    </div>
</footer>
<script>
    function confirmAdd() {
        return confirm("Bạn có chắc chắn muốn Add.");
    }
</script>
<script src="/js/bootstrap.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>

</body>
</html>
