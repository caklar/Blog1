<!--liu wei update 7-16-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,viewport-fit=cover">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homepage_style.css">
    <title>blog_test</title>
</head>

<body>

    <header>

        <div class='nav_bar'>

            <div><a href="">首页</a></div>
            <div><a href="" id="archive">归档</a></div>
            <div><a href="article_classname_Servlet">标签</a></div>
            <div><a href="">关于</a></div>
            <div><a href="">朋友</a></div>
            <div><a href="">常用站点</a></div>
        </div>


    </header>


    <main>


        <div class="title">
            <div>首页标题</div>
            <div>描述</div>

        </div>

        <div class="content">
            <ul id='article_list'>
                <li>article</li>
                <li>article</li>
                <li>article</li>
                <li>article</li>
                <li>article</li>
                <li>article</li>
                <li>article</li>

            </ul>



        </div>

        <div class="author_func">
            操作文章
        </div>

    </main>


</body>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js">

</script>

</html>