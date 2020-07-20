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
  <link rel="stylesheet" href="public.css"> 

  <title>blog_test</title>
</head>

<body style="overflow:auto;overflow-x: hidden">

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
        <div class="bar_menu_ch"><a href="" id="archive">归档</a></div>
        <div class="bar_menu_ch"><a href="">标签</a></div>
        <div class="bar_menu_ch"><a href="">关于</a></div>
        <div class="bar_menu_ch"><a href="">朋友</a></div>
        <div class="bar_menu_ch"><a href="">常用站点</a></div>
      </div>


    </div>


  </header>


  <main>


    <div class="title">
      <div class="site_name">Big Carrot</div>
      <div class="site_des">人们依然相信 什么未来会更精彩</div>

    </div>

    <div class="content">
      <ul id='article_list'>
        <li>

          <div class="article_title">
            链式存储二叉树的遍历
          </div>
          <div class="article_last_date">
            2020-05-29
          </div>

          <div class="article_pre">
            先序遍历，中序遍历，后序遍历以及层次遍历。 使用递归、队列。 整理自Leetcode。 说明 使用到的树结点类型为： struct TreeNode { int val; struct TreeNode *left;
            ...
          </div>



          <p>
            <button class="read_more" class="read_button">
              <a href="https://www.baidu.com">

                READ MORE

              </a>
            </button>
          </p>


        </li>

        <li>

          <div class="article_title">
            leetcode链表初等整理
          </div>
          <div class="article_last_date">
            2020-05-25
          </div>
          <div class="article_pre">
            力扣关于链表这部分基础算法还是较为简单和基础的 没有特殊说明的情况下，链表节点类型为： struct ListNode { int val; struct ListNode *next; };
            同时，需要注意，默认的头指...
          </div>



          <p>
            <button class="read_more" class="read_button">
              READ MORE
            </button>
          </p>

        </li>
        <li>

          <div class="article_title">
            链式存储二叉树的遍历
          </div>
          <div class="article_last_date">
            2020-05-29
          </div>

          <div class="article_pre">
            先序遍历，中序遍历，后序遍历以及层次遍历。 使用递归、队列。 整理自Leetcode。 说明 使用到的树结点类型为： struct TreeNode { int val; struct TreeNode *left;
            ...
          </div>



          <p>
            <button class="read_more" class="read_button">
              READ MORE
            </button>
          </p>

        </li>
        <li>

          <div class="article_title">
            链式存储二叉树的遍历
          </div>
          <div class="article_last_date">
            2020-05-29
          </div>

          <div class="article_pre">
            先序遍历，中序遍历，后序遍历以及层次遍历。 使用递归、队列。 整理自Leetcode。 说明 使用到的树结点类型为： struct TreeNode { int val; struct TreeNode *left;
            ...
          </div>



          <p>
            <button class="read_more" class="read_button">
              READ MORE
            </button>
          </p>

        </li>
        <li>

          <div class="article_title">
            链式存储二叉树的遍历
          </div>
          <div class="article_last_date">
            2020-05-29
          </div>

          <div class="article_pre">
            先序遍历，中序遍历，后序遍历以及层次遍历。 使用递归、队列。 整理自Leetcode。 说明 使用到的树结点类型为： struct TreeNode { int val; struct TreeNode *left;
            ...
          </div>



          <p>
            <button id="read_more" class="read_button">
              READ MORE
            </button>
          </p>

        </li>


      </ul>




    </div>
    <!-- 
    <div class="author_func">
      操作文章

    </div> -->

    <div class="aside">
      <ul class="aside-func">
        <li>新建</li>
        <li>修改</li>
        <li>删除</li>
        <li id="top">top</li>
      </ul>
    </div>


    <div class="page_jump">
      <div class="left_page">
        <a href="">← 上一页</a>


      </div>

      <div>

        <a href="">下一页 →</a>
      </div>
    </div>


  </main>

  <footer class="foot">

    --©2020-2020 --本站总访问量??次--Powered by ??--
  </footer>

</body>
<script src="//at.alicdn.com/t/font_1953733_jaco4732ny.js">

</script>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
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

</html>