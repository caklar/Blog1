<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>

    <head  lang="en">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="../css/public.css">
        <link rel="stylesheet" href="../css/frame.css">
        <link rel="stylesheet" href="../css/ArcAndClass.css">
        <script src="../../src/js/jquery-3.5.1.min.js"></script>
    </head>

    <body>
        <div class="nav">
            <a href="#">首页</a>
            <a href="#">归档</a>
            <a href="#">分类</a>
            <a href="#">关于</a>
            <a href="#">朋友</a>
            <a href="#">常用站点</a>
        </div>
        <div class="content">
            <div class="main-content">
                <%--获取文章分类页面--%>
                <ul>
                    <c:forEach var="items" items="${claAndNum}">
                        <li>
                            <a href="#">${items.class_id}</a>
                            <span>${items.class_name}</span>
                            <span>${items.num}</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="footer">
            <span>--©2020-2020--</span>
        </div>
        <script type="text/javascript">
            $(document).on("click", ".classOfArticles", function (e) {
                //$(this)或者$(e.target)获取当前元素


                //alert($(this).html())
                // alert(event.)
                var classId = $(this).html();
                //alert(classId);
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.request.contextPath}/ClassificationGetArticlesServlet?class_id=' +
                        classId,
                    data: {},
                    dataType: "html",
                    success: function (result, msg) {
                        //alert(result);
                        var html = "";
                        $("#main").html(result);
                    },
                    error: function (xhr, errorMsg, error) {
                        alert(xhr.status);
                        alert(errorMsg); //console.log();
                    }
                });
            })
        </script>
    </body>

</html>