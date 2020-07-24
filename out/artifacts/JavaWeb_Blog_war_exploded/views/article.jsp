<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/frame.css">
        <link rel="stylesheet" href="css/public.css">
        <link rel="stylesheet" href="editor.md-master/css/editormd.css" />
        <link rel="stylesheet" href="css/article.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/frame.js"></script>
        <script src="editor.md-master/editormd.min.js"></script>
        <script src="js/click.js"></script>
    </head>

    <body>
        <div class="dialog_bg">
            <div class="dialog" id="normal">
                <span class="glyphicon glyphicon-remove" id="close1"></span>
                <input type="password" class="form-control" id="pass" placeholder="请输入口令"><br>
                <button class="btn btn-primary" id="confirm1">确认</button>
            </div>
            <div class="dialog" id="error">
                <span class="glyphicon glyphicon-remove" id="close2"></span>
                <p>口令错误!</p>
                <button class="btn btn-primary" id="confirm2">确认</button>
            </div>
        </div>
        <div class="nav">
            <a href="/JavaWeb_Blog_war_exploded/index.jsp">首页</a>
            <a href="JavaScript:void(0);" id="archive">归档</a>
            <a href="JavaScript:void(0);" id="classify">标签</a>
            <a href="/JavaWeb_Blog_war_exploded/GetOneArticleServlet?article_id=2">关于</a>
        </div>
        <div class="content">
            <div class="main-content" id="main">
                <div class="a-title">
                    <h1>${ title }</h1>
                </div>
                <div class="a-msg">
                    <span>${ date }</span>
<%--                    <span>最后修改时间${ ldate }</span>--%>
                </div>
                <div class="a-content" id="md">${ content }</div>
            </div>
        </div>
        <div class="comment-area" id="comment1">
            <div class="release">
                <div>
                    <input type="text" id="name" placeholder="昵称">
                </div>
                <div class="talk-out">
                    <textarea class="talk" id="comment" placeholder="请输入评论"></textarea>
                </div>
                <div class="bottom">
                    <button class="push">发布</button>
                </div>
            </div>
            <div class="list">
                <c:forEach var="i" items="${ comment_info }">
                    <div>
                        <p class="com-name">#<span id="remark_id">${ i.remark_id }</span>&nbsp;&nbsp;${ i.remark_name }</p>
                        <p class="com-date"><span>${ i.remark_date }</span><a href="javascript:;" class="com-delete">删除</a></p>
                        <p class="com-content">${ i.remark_context }</p>
                    </div>
                </c:forEach>
                <!-- <ul class="comment"></ul> -->
            </div>
        </div>
        <div class="aside">
            <ul class="aside-func">
                <div id="key">
                    <li id="new">新建</li>
                    <li id="update">修改</li>
                    <li id="delete">删除</li>
                    <li id="com-delete">控评</li>
                </div>
                <li id="top">top</li>
            </ul>
        </div>
        <div class="footer">
            <span>--©2020-2020--</span>
        </div>
        <script>
            // 将 html 以 markdown 形式显示
            $("#md").addClass("markdown-body editormd-html-preview")

            $('#close1').on('click', function () {
                $('.dialog_bg').css('display', 'none')
            })
            $('#close2').on('click', function () {
                $('.dialog_bg').css('display', 'none')
            })
            // 获取点击元素对象
            var click_id
            $('#key').on('click', function (e) {
                $('.dialog_bg').css('display', 'block')
                e = e || window.e
                click_id = $(e.target).attr('id')
                console.log(click_id)
            })

            // 请求口令
            $('#confirm1').on('click', function () {
                $.ajax({
                    url: './EncryptServlet',
                    method: 'GET',
                    data: {
                        token: $('#pass').val()
                    },
                    dataType: 'json',
                    success: function (res) {
                        console.log(res)
                        if (res == '1') {
                            // 根据点击对象请求页面
                            if (click_id == 'new') {
                                location.href = '/JavaWeb_Blog_war_exploded/views/newArticle.html'
                            } else if (click_id == 'update') {
                                location.href = 'GetUpdateArticleInfoServlet?article_id=${ article_id }'
                            } else if (click_id == 'delete') {
                                location.href = 'DeleteArticleServlet?article_id=${ article_id }'
                            } else if (click_id == 'com-delete') {
                                $('.list a').css('display', 'block')
                                $('.dialog_bg').css('display', 'none')
                            }
                        } else if (res == '0') {
                            $('#normal').hide()
                            $('#error').show()
                        }
                    }
                })
            })

            // 控制两个盒子显示隐藏
            $('#confirm2').on('click', function () {
                $('#normal').show()
                $('#error').hide()
            })
            $('#name').on('focus', function () {
                $(this).css('border-bottom-color', '#000')
            })
            $('#name').on('blur', function () {
                $(this).css('border-bottom-color', '#e3e3e3')
            })

            let remark_id
            $('.push').on('click', function () {
                let get_name = $('#name').val();
                let get_content = $('#comment').val();
                // 获取发布时时间
                let time = new Date();
                let year = time.getFullYear();
                let month = time.getMonth() + 1;
                let day = time.getDate();
                // 格式化

                month = month < 10 ? '0' + month : month;
                day = day < 10 ? '0' + day : day;
                let push_time = year + '-' + month + '-' + day
                $('#name').val('')
                $('#comment').val('')
                $.ajax({
                    url: './new_comment_Servlet',
                    method: 'GET',
                    data: {
                        remark_aid: ${ article_id },
                        remark_name: get_name,
                        remark_context: get_content,
                        remark_date: push_time
                    },
                    dataType:'json',
                    success: function (res) {
                        // console.log('success')
                        remark_id = res
                        $('.list').prepend(`
                            <div>
                                <p class="com-name">#<span id="remark_id">` + remark_id + `</span>&nbsp;&nbsp;` + get_name + `</p>
                                <p class="com-date"><span>` + push_time + `</span><a href="javascript:;" class="com-delete">删除</a></p>
                                <p class="com-content">` + get_content + `</p>
                            </div>
                        `)
                    }
                })
            });
            $('.list').on('click', 'a', function () {
                let remark_id = $(this).parent().prev().children('#remark_id').html()
                let this_a = $(this)
                console.log(remark_id)
                $.ajax({
                    url: './comment_del_Servlet',
                    method: 'GET',
                    data: {
                        remark_id: remark_id,
                    },
                    dataType:'json',
                    success: function () {
                        this_a.parent().parent().remove()
                    }
                })
            })
        </script>
        <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/wsy.js"></script>
    </body>

</html>