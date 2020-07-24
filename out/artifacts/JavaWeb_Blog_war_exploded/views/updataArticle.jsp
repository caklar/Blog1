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
    <link rel="stylesheet" href="css/newArticle.css">
    <link rel="stylesheet" href="editor.md-master/css/editormd.css" />
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="editor.md-master/editormd.min.js"></script>
    <script type="text/javascript"> 
        $(function() {
            <%--var 完了崔酱犯蠢了 = '${ a_id }'--%>
            // markdown 编辑器设置
            var editor = editormd("test-editor", {
                width  : "99%",
                height : 680 + 'px',
                path: "editor.md-master/lib/",
                saveHTMLToTextarea : true,
                emoji: true
            })

            // 分类提示
            $('#class').on('focus', function () {
                // 获得焦点淡入
                $('.class_tip').fadeIn();

                $('.class_tip').html('')
                // 请求获取所有分类名称
                $.ajax({
                    url: './ClassFuzzyMatchServlet',
                    method: 'GET',
                    data: {
                        class_tip: ''
                    },
                    dataType: 'json',
                    success: function (res) {
                        if (res) {
                            // console.log(res)
                            for (let i = 0; i < res.length; i++) {
                                $('.class_tip').append('<a href="#">' + res[i] + '</a>')
                            }
                        }
                    }
                })
            })
            // 失去焦点淡出
            $('#class').on('blur', function () {
                $('.class_tip').fadeOut();
            })
            // 输入时根据内容显示分类
            $('#class').on('keyup', function() {
                // 清空显示内容
                $('.class_tip').html('')

                // 取出输入框内容
                class_tip = $('#class').val()
                // $('.class_tip').append('<a href="#">123</a>')
                $.ajax({
                    url: './ClassFuzzyMatchServlet',
                    method: 'GET',
                    data: {
                        class_tip: class_tip
                    },
                    dataType: 'json',
                    success: function (res) {
                        if (res) {
                            for (let i = 0; i < res.length; i++) {
                                $('.class_tip').append('<a href="#">' + res[i] + '</a>')
                            }
                        }
                    }
                })
            })
            // 点击分类时将其显示在输入框
            $('.class_tip').on('click', 'a', function () {
                console.log($(this))
                $('#class').val($(this).html())
            })

            // 提交点击事件
            $('#publish').on('click', function () {
                // 获取 markdown 对应的 html 字符串
                var contentHtml = editor.getHTML()
                // 获取文章标题
                var title = $('#title').val()
                // 获取md
                var contentMd = $('#md').val()
                // 获取文章分类
                var cname = $('#class').val()
                // 获取当前日期
                var nowDate = new Date()
                // 日期格式化
                var month = nowDate.getMonth() + 1
                var date = nowDate.getDate()
                if (month < 10) {
                    month = '0' + month
                }
                if (date < 10) {
                    date = '0' + date
                }
                nowDate = nowDate.getFullYear() + '-' + month + '-' + date
                if (title === '' || contentHtml === '' || cname === '') {
                    alert('内容不能为空!')
                } else {
                    $.ajax({
                        url: './SetUpdateArticleInfoServlet',
                        method: 'POST',
                        data: {
                            a_id: ${ a_id },
                            title: title,
                            ldate: nowDate,
                            content: contentHtml,
                            contentMd: contentMd,
                            cname: cname
                        },
                        dataType: 'json',
                        success: function (res) {
                            if (res) {
                                alert("发布成功");
                                location.href="/JavaWeb_Blog_war_exploded/GetOneArticleServlet?article_id="+res;
                            }
                        }
                    })
                }
            })
        });
    </script>
</head>
<body>
    <div class="nav">
        <span>标题</span>
        <input type="text" id="title" placeholder="请输入文章标题" value="${ title }">
        <span>分类</span>
        <input type="text" id="class" placeholder="请输入文章分类" value="${ cname }">
        <button class="btn btn-default" id="publish">修改文章</button>
        <div class="class_tip"></div>
    </div>
    <div id="test-editor">
        <textarea style="display:none;" id="md">${ content }</textarea>
    </div>
</body>
</html>