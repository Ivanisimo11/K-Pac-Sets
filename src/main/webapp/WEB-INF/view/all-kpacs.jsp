<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All K-Paces</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>

<style>
    * {
        font-family: 'Roboto', sans-serif;
    }

    .table {
        border-collapse: collapse;
        border: 1px solid #000;
    }

    .table > tr {
    }

    .table tr + tr {
        border-top: 0;
    }

    .table td, th {
        border: 1px solid #000;
        padding: 10px 20px;
    }

    .btn {
        border: 0;
        border-radius: 6px;
        background-color: #40de68;
        box-shadow: 2px 2px 15px 5px rgba(0, 0, 0, 0.1);
        text-align: center;
        padding: 10px 20px;
        transition: all 0.3s;
        cursor: pointer;
        color: #fff;
    }

    .btn:hover {
        transform: translateY(-2px);
        box-shadow: 2px 2px 17px 7px rgba(0, 0, 0, 0.08);
    }

    .btn__delete {
        background-color: rgb(245, 0, 0);
        color: #fff;
    }

    a {
        text-decoration: none;
        font-size: 20px;
        font-weight: bold;
        color: #60a7f7;
    }
</style>

<body >



<%--@elvariable id="kPac" type="com.ivan.entity.K_Pac"--%>
<form:form action="saveKPac" modelAttribute="kPac" >

    Id<form:input path="id" cssStyle="margin-right: 30px" />
    Title <form:input path="title" cssStyle="margin-right: 30px"/>
    Description <form:input path="description" cssStyle="margin-right: 30px"/>

    <button class="btn" type="submit">Create K-Pac</button>


</form:form>
<br><br>

<table width="100%" border="1">

    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Date Created</th>
    </tr>
    <tr>
        <c:forEach var="pac" items="${all_k_paces}">
        <c:url var="deleteButton" value="/deleteKPac">
            <c:param name="kPacId" value="${pac.id}"/>
        </c:url>
    <tr>
        <td width="350">${pac.title}</td>
        <td width="1000">${pac.description}</td>
        <td width="120">${pac.dateCreated}</td>
        <td>
            <button class="btn btn__delete" type="button"
                    onclick="window.location.href = '${deleteButton}'">Delete
            </button>
        </td>
    </tr>
    </c:forEach>
</table>
<br><br>
<button type="button" class="btn"
        onclick="window.location.href = '/sets'">Sets</button>
</body>
</html>

