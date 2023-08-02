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

        .form-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        .form-container label {
            display: block;
            margin-bottom: 10px;
        }

        .form-container input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        .form-container button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-container button[type="submit"]:hover {
            background-color: #45a049;
        }

    </style>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<h5><p class="text-center">Dong do choi</p></h5>
<div class="container-fluid">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <br>


            <div class="form-container">
                <form:form method="POST" action="/dong-san-pham/add" modelAttribute="dongDoChoi">
                    <label for="ma">Ma:</label>
                    <form:input path="ma"/>
                    <br>
                    <label for="ten">Ten:</label>
                    <form:input path="ten"/>
                    <br><br>
                    <button type="submit">Add</button>
                </form:form>
            </div>


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
                                    <c:forEach items="${listDong}" var="dong" varStatus="i">
                                        <tr>
                                            <th scope="row">${i.count}</th>
                                            <td>${dong.ma}</td>
                                            <td>${dong.ten}</td>
                                            <td>
                                                <a href="/dong-san-pham/view-update/${dong.id}"
                                                   class="btn btn-sm btn-warning">Edit</a>

                                                <a class="btn btn-sm btn-warning"
                                                   onclick="return confirm('Bạn chắc chắn xóa chứ ?')"
                                                   href="/dong-san-pham/delete/${dong.id}">Delete</a>


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
