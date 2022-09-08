<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Sets</title>
</head>
<body >
<%--@elvariable id="set" type="com.ivan.entity.Set"--%>
<form:form action="saveSet" modelAttribute="set" >
    Id<form:input path="id" cssStyle="margin-right: 30px" />
    Title <form:input path="title" cssStyle="margin-right: 30px"/>
    <input type="submit" value="Create Set"/>

</form:form>
<br><br>

<table width="100%" border="1">
    <tr>
        <th>Title</th>
    </tr>
    <tr>
        <c:forEach var="set" items="${all_sets}">
        <c:url var="deleteButton" value="/deleteSet">
            <c:param name="setId" value="${set.id}"/>
        </c:url>
    <tr>
        <td width="1470" >
            <a href="
                <c:url value="/set">
                    <c:param name="setId" value="${set.id}"/>
                </c:url>
            ">${set.title}</a>
        </td>
        <td>
            <input type="button" value="Delete"
                   onclick="window.location.href = '${deleteButton}'">
        </td>
    </tr>
    </c:forEach>
</table>
<br><br>
<input type="button" value="K-Packs"
       onclick="window.location.href = '/kpacs'">
</body>
</html>

