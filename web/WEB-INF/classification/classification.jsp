<%--
  Created by IntelliJ IDEA.
  User: 15P-5545
  Date: 2020/7/19
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="items" items="${claAndNum}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/ClassificationGetArticlesServlet?class_id=${items.class_id}">${items.class_id}</a></td>
            <td>${items.class_name}</td>
            <td>${items.num}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
