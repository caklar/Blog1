<%--
  Created by IntelliJ IDEA.
  User: 15P-5545
  Date: 2020/7/19
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="items" items="${articles}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/ClassificationGetArticlesServlet?class_id=${items.a_id}">${items.a_id}</a></td>
            <td>${items.a_title}</td>
            <td>${items.a_ldate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
