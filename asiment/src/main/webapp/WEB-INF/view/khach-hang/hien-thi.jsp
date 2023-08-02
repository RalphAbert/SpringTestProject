<%--
  Created by IntelliJ IDEA.
  User: HP probook
  Date: 02/04/2023
  Time: 4:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            text-align: center;
        }

    </style>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<h5><p class="text-center">Màu sắc</p></h5>
<div class="container-fluid">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <br>
        </div>
        <div class="col-1"></div>
    </div>

    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">


            <c:if test="${not empty successMessage}">
                <div class="alert alert-success">
                        ${successMessage}
                </div>
            </c:if>
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Ten</th>
                                        <th scope="col">SDT</th>
                                        <th scope="col">DiaChi</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Mat Khau</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${khachHangs}" var="kh" varStatus="i">
                                        <tr>
                                            <th scope="row">${i.count}</th>
                                            <td>${kh.ten}</td>
                                            <td>${kh.sdt}</td>
                                            <td>${kh.diaChi}</td>
                                            <td>${kh.email}</td>
                                            <td>${kh.matKhau}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="col-1"></div>
</div>

<script>

    function confirmRemove() {
        return confirm("Bạn có chắc chắn muốn Remove.");
    }

    function confirmAdd() {
        return confirm("Bạn có chắc chắn muốn Add .");
    }

</script>

</body>
</html>
