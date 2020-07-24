<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/public.css">
        <link rel="stylesheet" href="css/frame.css">
        <link rel="stylesheet" href="css/ArcAndClass.css">
        <script src="js/jquery-3.5.1.min.js"></script>
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
                <ul>
                    <c:forEach var="items" items="${articles}">
                    <li>
                        <a href="#" class="article">${items.a_id}</a>
                        <span>${items.a_title}</span>
                        <span>${items.a_ldate}</span>
                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="aside">
            <ul class="aside-func">
                <li>新建</li>
                <li id="top">top</li>
            </ul>
        </div>
        <div class="footer">
            <span>--©2020-2020--</span>
        </div>
        <script>
            // $(document).on("click", ".article", function (e) {
            //     //$(this)或者$(e.target)获取当前元素
            //     //alert(1)
            //
            //     //alert($(this).html())
            //     // alert(event.)
            //     var a_id=$(this).html();
            //     //alert(classId);
            //
            //     $.ajax({
            //         type: 'POST',
            //         url: ''+a_id,
            //         data: {},
            //         dataType:"html",
            //         success: function(result,msg){
            //             alert(result);
            //             var html = "";
            //             console.log(result);
            //             $("#main").html(result);
            //         },
            //         error:function(xhr,errorMsg,error){
            //             alert(xhr.status);
            //             alert(errorMsg);//console.log();
            //         }
            //     });
            // })
        </script>

    </body>

</html>