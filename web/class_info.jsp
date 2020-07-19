<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/7/18
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>class_info</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>
            类别ID
        </td>
        <td>
            类别名称
        </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="t" items="${class_info_test }">
        <tr>
            <td>
                <input type="checkbox" name="ids" value="${t}">
            </td>
            <td>${t.class_id}</td>
            <td>${t.class_name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
