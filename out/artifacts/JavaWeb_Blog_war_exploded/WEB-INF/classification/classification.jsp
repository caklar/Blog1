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
        <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/frame.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ArcAndClass.css">--%>
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    </head>
    <style type="text/css">
        /*div{
            display: inline;
        }*/
        .box{
            width: 100px;
            /*height: 50px;*/
            background: #fef9ff;
            border-radius: 30px;
            margin: 20px;
            display: inline-block;
            font-size: 16px;
            text-align:center;
            /*//padding-top: 50%;*/
            line-height: 50px;
        }
        .box:hover{
            background: #bafff5;
        }
        .num{
            height: 10px;
            width: 10px;
            border-radius: 5px;
            background-color: #A9A9A9;
        }
        #body{
            margin-top: -100px;
        }
    </style>

    <body>
                <%--获取文章分类页面--%>
                <%--<table>
                    <c:forEach var="items" items="${claAndNum}">
                        <tr>
                            <td><a href="JavaScript:void(0);" class="classOfArticles" id="${items.class_id}">${items.class_name}</a></td>
                            <td><span>${items.num}</span></td>
                        </tr>
                    </c:forEach>
                </table>--%>
                <div id="body">
                    <c:forEach var="items" items="${claAndNum}" >

                        <a href="JavaScript:void(0);" class="classOfArticles" id="${items.class_id}">
                            <div class="box">
                                ${items.class_name}
                                    <span class="num">${items.num}</span>
                            </div>
                        </a>


                    </c:forEach>
                </div>

        <script type="text/javascript">
            $(document).on("click", ".classOfArticles", function (e) {
                //$(this)或者$(e.target)获取当前元素


                //alert($(this).html())
                // alert(event.)
                var classId = $(this).attr("id");
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