<%--
  Created by IntelliJ IDEA.
  User: 15P-5545
  Date: 2020/7/19
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--获取文章分类页面--%>
<table>
    <c:forEach var="items" items="${claAndNum}">
        <tr>
            <td><span class="classOfArticles">${items.class_id}</span></td>
            <td>${items.class_name}</td>
            <td>${items.num}</td>
        </tr>
    </c:forEach>
</table>
</body>
<script type="text/javascript">
    $(".classOfArticles").click(function(event){


    });

    $(document).on("click", ".classOfArticles", function (e) {
        //$(this)或者$(e.target)获取当前元素


        //alert($(this).html())
        // alert(event.)
        var classId=$(this).html();
        //alert(classId);
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/ClassificationGetArticlesServlet?class_id='+classId,
            data: {},
            dataType:"html",
            success: function(result,msg){
                //alert(result);
                var html = "";
                $("#main").html(result);
            },
            error:function(xhr,errorMsg,error){
                alert(xhr.status);
                alert(errorMsg);//console.log();
            }
        });
    })
</script>
</html>
