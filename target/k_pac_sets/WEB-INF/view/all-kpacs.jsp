<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All K-Paces</title>
</head>
<body >



<%--@elvariable id="kPac" type="com.ivan.entity.K_Pac"--%>
<form:form action="saveKPac" modelAttribute="kPac" >

    Id<form:input path="id" cssStyle="margin-right: 30px" />
    Title <form:input path="title" cssStyle="margin-right: 30px"/>
    Description <form:input path="description" cssStyle="margin-right: 30px"/>

    <input type="submit" value="Create K-PAC"/>

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
            <input type="button" value="Delete"
                   onclick="window.location.href = '${deleteButton}'">
        </td>
    </tr>
    </c:forEach>
</table>
<br><br>
<input type="button" value="Sets"
       onclick="window.location.href = '/sets'">
</body>
</html>

