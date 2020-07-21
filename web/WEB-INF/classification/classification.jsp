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

<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css">--%>
<html>
<head>
    <title>Title</title>
    <%--<style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        .classOfArticles{
            color: red;
            border: 1px solid black;
        }
    </style>
</head>--%>
<body>
<%--获取文章分类页面--%>
<%--<div class="py-8 shadow-box bg-white dark:bg-gray-600 border-gray-300 rounded-none md:rounded-lg -mx-1 md:mx-0 md:px-0">--%>
<%--    <div class="px-8 pb-5 inline-flex relative overflow-hidden">--%>
<%--        <a href="https://lizonglin313.github.io/tag/FvEjZM6o_C" class="text-gray-700 dark:text-gray-200 border-b-2 border-dotted border-gray-200 dark:border-gray-400 dark:hover:border-gray-200 hover:border-gray-600 transition-all duration-100">--%>
<%--            <i class="ri-hashtag"></i>--%>
<%--            复习整理（3）--%>
<%--        </a>--%>
<%--    </div>--%>
<%--</div>--%>

    <c:forEach var="items" items="${claAndNum}">
        <a href="JavaScript:void(0);" id="${items.class_id}" class="classOfArticles">
            <i class=""></i>
                ${items.class_name}<span class="badge">${items.num}</span>
        </a>
    </c:forEach>
<%--<div class="btn-group" role="group" aria-label="...">
    <button type="button" class="btn btn-default">Left</button>
    <button type="button" class="btn btn-default">Middle</button>
    <button type="button" class="btn btn-default">Right</button>
</div>--%>

</body>
<script type="text/javascript">


    $(document).on("click", ".classOfArticles", function (e) {
        //$(this)或者$(e.target)获取当前元素


        //alert($(this).html())
        // alert(event.)
        var classId=$(this).attr("id");
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
