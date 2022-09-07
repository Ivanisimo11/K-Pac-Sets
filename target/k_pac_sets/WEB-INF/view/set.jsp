<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>K-Paces In Set 1</title>
</head>
<body>
<center><h3>K-Packs in this Set</h3></center>
<table width="100%" border="1">

    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Date Created</th>
    </tr>
    <tr>
        <c:forEach var="pac" items="${k_PacksInSet}">
        <c:url var="deleteButton" value="/deleteKPacFromSet">
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

<br><br><br>
<center><h3>You can add these K-Packs to this Set</h3></center>
<table width="100%" border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Date Created</th>
    </tr>
    <tr>
        <c:forEach var="pac" items="${k_PacksWhichCanBeAdded}">
        <c:url var="addButton" value="/addKPacToSet">
            <c:param name="kPacId" value="${pac.id}"/>
        </c:url>
    <tr>
        <td width="350">${pac.title}</td>
        <td width="1000">${pac.description}</td>
        <td width="120">${pac.dateCreated}</td>
        <td>
            <input type="button" value="ADD"
                   onclick="window.location.href = '${addButton}'">
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>

