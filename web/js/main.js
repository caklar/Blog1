
let article;

let pn = 0;
let an = 0;

const request = new XMLHttpRequest();
request.open("GET", `index`);

request.onreadystatechange = () => {
    if (request.readyState === 4 && request.status === 200) {

        article_list.querySelectorAll("li").forEach(item => {
            item.remove();
        })

        article = JSON.parse(request.response.replace(/[\n\r]/g, "<br/>"));

        article.forEach(item => {

            article[an].article_preview = article[an].article_preview.substring(0, 20);

            $('#article_list').append(
                `   <li></li><div class="article_title">
                    ${article[an].title}
                    </div>

                    <div class="article_pre">
                    ${article[an].article_preview}
                    </div>

                    <div class="article_last_date">
                    ${article[an].ldate}
                    </div>

                    <p>
                    <button class="read_more" class="read_button">
                        <a href="${article[an].url}">
                        READ MORE
                        </a>
                    </button>
                    </p></li>`
            );
            an += 1;
        });
        an = 0;
    }
};
request.send();



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
