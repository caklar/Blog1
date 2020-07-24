<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
       <%--<link rel="stylesheet" href="css/public.css">
        <link rel="stylesheet" href="css/frame.css">
        <link rel="stylesheet" href="css/ArcAndClass.css">
        <script src="js/jquery-3.5.1.min.js"></script>--%>
    </head>
    <style type="text/css">
        div{
            margin: 0px;
            padding: 0px;
        }
        .article{
            width: 700px;
            height: 50px;
            line-height: 50px;
            border-radius: 25px;
            /*margin: 0 auto;*/
            /*margin-left: ;*/
            margin-left: 40px;
        }
        .articleName {
            width: 40%;
            height: 100%;
            display: inline-block;
            /*margin-left: -150px;*/
            padding-left: 30px;

        }
        .articleDate {
            width: 50%;
            height: 100%;
            display: inline-block;
            /*padding-right: -200px;*/
            /*text-align: right;*/
            /*margin-right: -200px;*/
            /*padding-right:100px ;*/
            text-align: right;
        }
        .article:hover{
            background-color: #bafff5;
        }
        #head{
            background-color: #9d937c;
        }
        .containerOfli {
            height: 60px;
        }
        ul{
            margin-top: -100px;
        }
    </style>

    <body>


                <ul style="">
                    <li class="containerOfli">
                        <a href="javascript:return false;" class="article" style="margin-left: 30px;cursor:default">

                            <div class="article" id="head">
                                <div class="articleName" style="">
                                    <strong>文章标题</strong>
                                </div>
                                <div class="articleDate" style="">
                                    <span><strong>文章日期</strong></span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <c:forEach var="items" items="${articles}">
                        <li>
                            <a href="${pageContext.request.contextPath}/GetOneArticleServlet?article_id=${items.a_id}" class="article" style="">

                                <div class="article">
                                    <div class="articleName" style="">
                                            ${items.a_title}
                                    </div>
                                    <div class="articleDate" style="">
                                        <span>${items.a_date}</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                    </c:forEach>
                </ul>

                <%--<table>

                    <c:forEach var="items" items="${articles}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/GetOneArticleServlet?article_id=${items.a_id}" class="article">${items.a_title}</a></td>
                        <td><span>${items.a_date}</span></td>
                    </tr>
                    </c:forEach>
                </table>--%>



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