<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,viewport-fit=cover">


    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <style type="text/css">
        .icon {
            width : 1em;
            height : 1em;
            vertical-align : -.15em;
            fill : currentColor;
            overflow : hidden;
        }

    </style>



    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homepage_style.css">
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">--%>
    <%--    <link rel="stylesheet" href="public.css">--%>

    <title>blog_test</title>
</head>

<body style="overflow:auto;overflow-x: hidden">

<div class="dialog_bg">
    <div class="dialog" id="normal">
        <div class="close" id="close1"></div>
        <input type="password" class="form-control" id="pass" placeholder="请输入口令"><br>
        <button class="btn btn-primary" id="confirm1">确认</button>
    </div>
    <div class="dialog" id="error">
        <div class="close" id="close2"></div>
        <p>口令错误!</p>
        <button class="btn btn-primary" id="confirm2">确认</button>
    </div>
</div>

<header>

    <div class='nav_bar'>
        <button class="bar_menu">
            <svg t="1595205271412" class="show_icon" viewBox="0 0 1024 1024" version="1.1"
                 xmlns="http://www.w3.org/2000/svg" p-id="822" width="37" height="37">
                <path
                        d="M128 768l768 0 0-85.333333L128 682.666667 128 768zM128 554.666667l768 0 0-85.333333L128 469.333333 128 554.666667zM128 256l0 85.333333 768 0L896 256 128 256z"
                        p-id="823" fill="#2c2c2c"></path>
            </svg>

        </button>
        <div class="menu_panel">

            <div class="bar_menu_ch"><a href="">首页</a></div>
            <div><a href="JavaScript:void(0);" id="archive">归档</a></div>
            <div><a href="JavaScript:void(0);" id="classify">标签</a></div>
            <div class="bar_menu_ch"><a href="/JavaWeb_Blog_war_exploded/GetOneArticleServlet?article_id=2">关于</a></div>
        </div>


    </div>


</header>


<main>


    <div class="title" >
        <div class="site_name">个人博客系统</div>
        <div class="site_des">生产实习7组---系统展示</div>

    </div>

    <div class="content" id="main">
            <ul id='article_list'>


        </ul>




    </div>
    <!--
    <div class="author_func">
      操作文章

    </div> -->

    <div class="aside">
        <ul class="aside-func">
            <div id="key">
                <li id="new">新建</li>
            </div>
            <li id="top">top</li>
        </ul>
    </div>


    <div class="page_jump">
        <div class="left_page" >
            <a href="JavaScript:void(0)" >← 上一页</a>

        </div>

        <div class = "right_page" id="nextPage">

            <a href="JavaScript:void(0)">下一页 →</a>
        </div>
    </div>


</main>

<footer class="foot">

    --©2020-2020--Powered by 717HUB--
</footer>

</body>
<script src="//at.alicdn.com/t/font_1953733_jaco4732ny.js">

</script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/wsy.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js">
</script>


<script>
    $(window).on('scroll', function () {

        if ($(this).scrollTop() > 150) {
            $(".nav_bar").css({ "padding-top": "22px", "padding-bottom": "12px" })
        } else {
            $(".nav_bar").css({ "padding-top": "32px", "padding-bottom": "18px" })
        }


        if ($(this).scrollTop() > 200) {
            $('#top').show()

        } else {
            $('#top').hide()
        }
        if ($(this).scrollTop() > 120) {
            $('.nav').css('padding', '16px 0')
        } else {
            $('.nav').css('padding', '32px 0')
        }
    })
    $('#top').on('click', function () {
        clearInterval(timer)
        var timer = setInterval(function () {
            if ($(window).scrollTop() > 0) {
                let top = $(window).scrollTop() - 100
                $(window).scrollTop(top)
            } else {
                clearInterval(timer)
            }
        }, 10)
    })



</script>
<script src="js/click.js"></script>
</html>