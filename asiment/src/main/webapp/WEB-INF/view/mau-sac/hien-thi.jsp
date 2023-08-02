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


            <form:form method="POST" action="/mau-sac/add" modelAttribute="mauSac">

                Ma:
                <form:input path="ma"/>
                <br>
                Ten:
                <form:input path="ten"/>
                <br>
                <br>
                <button type="submit">Add</button>
            </form:form>


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
                                        <th scope="col">Mã</th>
                                        <th scope="col">Tên</th>
                                        <th scope="col">Chức năng</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listMS}" var="ms" varStatus="i">
                                        <tr>
                                            <th scope="row">${i.count}</th>
                                            <td>${ms.ma}</td>
                                            <td>${ms.ten}</td>
                                            <td>
                                                <a href="/mau-sac/detail?id=${ms.id}" class="btn btn-sm btn-primary">Detail</a>
                                                <a href="/mau-sac/view-update/${ms.id}"
                                                   class="btn btn-sm btn-warning">Edit</a>

                                            <td><a class="btn btn-sm btn-warning"
                                                   onclick="return confirm('Bạn chắc chắn xóa chứ ?')"
                                                   href="/mau-sac/delete/${ms.id}">Delete</a></td>


                                            </td>
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
