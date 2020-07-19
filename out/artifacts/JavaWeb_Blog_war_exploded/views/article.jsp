<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/public.css">
        <link rel="stylesheet" href="editor.md-master/css/editormd.css" />
        <link rel="stylesheet" href="css/article.css">
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="editor.md-master/editormd.min.js"></script>
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
                <div class="a-title">
                    <h1>${ title }</h1>
                </div>
                <div class="a-msg">
                    <span>${ date }</span>
                </div>
                <div class="a-content" id="md">${ content }</div>
            </div>
        </div>
        <div class="aside">
            <ul class="aside-func">
<%--                <li>新建</li>--%>
                <a href="/JavaWeb_Blog_war_exploded/views/newArticle.html">新建</a>
                <li>修改</li>
                <li>删除</li>
                <li id="top">top</li>
            </ul>
        </div>
        <div class="footer">
            <span>--©2020-2020--</span>
        </div>
        <script>
            $("#md").addClass("markdown-body editormd-html-preview")

            /* $('.aside-func').on('mouseenter', 'li', function () {
                // for (let i = 0; i < 4; i++) {
                //     $(this).siblings().css('backgroundColor', 'white')
                // }
                $(this).css('backgroundColor', '#faf9f7')
            })
            $('.aside-func').on('mouseleave', 'li', function () {
                $(this).css('backgroundColor', '#fff')
            }) */

            $(window).on('scroll', function () {
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
    </body>

</html>