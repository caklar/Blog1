
let article;

let pn = 0;
let an = 0;
let article_index;

const request = new XMLHttpRequest();
request.open("GET", `index`);

let show_article = function () {
    for (an = 0; an < (article.length - 10 * pn < 10 ? article.length - 10 * pn : 10)
        ; an++) {

        article_index = 10 * pn + an;

        article[article_index].article_preview = article[article_index].article_preview.substring(0, 108);

        $('#article_list').append(
            `  <li>
                <div class="article_title">
                ${article[article_index].title}
                </div>
                
                <div class="article_last_date">
                ${article[article_index].ldate}
                </div>
                
                <div class="article_pre">
                ${article[article_index].article_preview}
                </div>

                <p>
                <button class="read_more" class="read_button">
                    <a href="GetOneArticleServlet?article_id=${article[article_index].article_id}">
                    READ MORE
                    </a>
                </button>
                </p>
            </li>`
        );

    };
    an = 0;
}


let mid_page = function () {
    $('.page_jump')
        .css({ "flex-direction": "row" })
        .find('.left_page')
        .css({ "display": "block" })
        .end()
        .find('.right_page')
        .css({ "display": "block" })
}

request.onreadystatechange = () => {
    if (request.readyState === 4 && request.status === 200) {

        article_list.querySelectorAll("li").forEach(item => {
            item.remove();
        })

        article = JSON.parse(request.response.replace(/[\n\r]/g, "<br/>"));

        show_article();

        article_index = 10 * pn+10;

        if (article.length <= article_index) {
            $('.page_jump')
                .find('.left_page')
                .css({ "display": "none" })
                .end()
                .find('.right_page')
                .css({ "display": "none" })
        }

    }
};
request.send();



$('.page_jump')
    .on('click', '.left_page', (e) => {

        $(window).scrollTop(0);

        article_list.querySelectorAll("li").forEach(item => {
            item.remove();
        })

        pn--;

        show_article();


        if (pn === 0) {
            $('.page_jump')
                .css({ "flex-direction": "row-reverse" })
                .find('.left_page')
                .css({ "display": "none" })
                .end()
                .find('.right_page')
                .css({ "display": "block" })
        }
        else {

            mid_page();
        }

    })
    .end()
    .on('click', '.right_page', (e) => {

        $(window).scrollTop(0);

        article_list.querySelectorAll("li").forEach(item => {
            item.remove();
        })

        pn++;

        show_article();


        article_index = 10 * pn + 10;

        if (article_index >= article.length) {
            $('.page_jump')
                .css({ "flex-direction": "row" })
                .find('.left_page')
                .css({ "display": "block" })
                .end()
                .find('.right_page')
                .css({ "display": "none" })

        } else {

            mid_page();
        }
    })


const menu_panel = document.getElementsByClassName("menu_panel")[0];


$(".bar_menu").on('click', ".show_icon", (e) => {

    $(".bar_menu")

        .find('.show_icon')
        .remove()

        .end()
        .append('<svg t="1595209066495" class="cancel_icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3451" width="34" height="34"><path d="M512 455.431L794.843 172.59a8 8 0 0 1 11.313 0l45.255 45.255a8 8 0 0 1 0 11.313L568.57 512 851.41 794.843a8 8 0 0 1 0 11.313l-45.255 45.255a8 8 0 0 1-11.313 0L512 568.57 229.157 851.41a8 8 0 0 1-11.313 0l-45.255-45.255a8 8 0 0 1 0-11.313L455.43 512 172.59 229.157a8 8 0 0 1 0-11.313l45.255-45.255a8 8 0 0 1 11.313 0L512 455.43z" p-id="3452"></path></svg>')


    menu_panel.style.display = 'flex';
});

$(".bar_menu")
    .on("click", ".cancel_icon", (e) => {

        $(".bar_menu")

            .find('.cancel_icon')
            .remove()

            .end()
            .append(` <svg t="1595205271412" class="show_icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
        p - id="822" width = "37" height = "37" >
        <path
            d="M128 768l768 0 0-85.333333L128 682.666667 128 768zM128 554.666667l768 0 0-85.333333L128 469.333333 128 554.666667zM128 256l0 85.333333 768 0L896 256 128 256z"
            p-id="823" fill="#2c2c2c"></path>
      </svg > `)

        $('.menu_panel').css("display", "none")

    }).end();




!function () {
    function n(n, e, t) {
        return n.getAttribute(e) || t
    }
    function e(n) {
        return document.getElementsByTagName(n)
    }
    function t() {
        var t = e("script"), o = t.length, i = t[o - 1];
        return { l: o, z: n(i, "zIndex", -1), o: n(i, "opacity", .5), c: n(i, "color", "0,0,0"), n: n(i, "count", 99) }
    }
    function o() {
        a = m.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,
            c = m.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight
    }
    function i() {
        r.clearRect(0, 0, a, c);
        var n, e, t, o, m, l;
        s.forEach(function (i, x) {
            for (i.x += i.xa, i.y += i.ya, i.xa *= i.x > a || i.x < 0 ? -1 : 1, i.ya *= i.y > c || i.y < 0 ? -1 : 1, r.fillRect(i.x - .5, i.y - .5, 1, 1), e = x + 1; e < u.length; e++)n = u[e],
            null !== n.x && null !== n.y && (o = i.x - n.x, m = i.y - n.y,
                l = o * o + m * m, l < n.max && (n === y && l >= n.max / 2 && (i.x -= .03 * o, i.y -= .03 * m),
                t = (n.max - l) / n.max, r.beginPath(), r.lineWidth = t / 2, r.strokeStyle = "rgba(" + d.c + "," + (t + .2) + ")", r.moveTo(i.x, i.y), r.lineTo(n.x, n.y), r.stroke()))
        }),
            x(i)
    }
    var a, c, u, m = document.createElement("canvas"),
        d = t(), l = "c_n" + d.l, r = m.getContext("2d"),
        x = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
            function (n) {
                window.setTimeout(n, 1e3 / 45)
            },
        w = Math.random, y = { x: null, y: null, max: 2e4 }; m.id = l, m.style.cssText = "position:fixed;top:0;left:0;z-index:" + d.z + ";opacity:" + d.o, e("body")[0].appendChild(m), o(), window.onresize = o,
        window.onmousemove = function (n) {
            n = n || window.event, y.x = n.clientX, y.y = n.clientY
        },
        window.onmouseout = function () {
            y.x = null, y.y = null
        };
    for (var s = [], f = 0; d.n > f; f++) {
        var h = w() * a, g = w() * c, v = 2 * w() - 1, p = 2 * w() - 1; s.push({ x: h, y: g, xa: v, ya: p, max: 6e3 })
    }
    u = s.concat([y]),
        setTimeout(function () { i() }, 100)
}();


$('#close1').on('click', function () {
    $('.dialog_bg').css('display', 'none')
    console.log('error')
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
