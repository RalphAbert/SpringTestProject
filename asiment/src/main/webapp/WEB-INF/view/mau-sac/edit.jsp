<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" action="/mau-sac/update/${mauSac.id}" modelAttribute="mauSac">


    Ma:
    <form:input path="ma"/>
    <br>
    Ten:
    <form:input path="ten"/>
    <br>


    <br>
    <button type="submit">Update</button>
</form:form>