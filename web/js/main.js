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

        article = JSON.parse(request.response.replace(/[\n\r]/g,"<br/>"))

        article.forEach(item => {
            $('#article_list').append(
                `   <div class="article_title">
                    ${article[an].title}
                    </div>
    
                    <div class="article_pre">
                    ${article[an].article_preview}
                    </div>
    
                    <div class="article_last_date">
                    ${article[an].ldate}
                    </div>
    
                    <p>
                    <button id="read_more" class="read_button">
                        READ MORE
                    </button>
                    </p>`
            );
            an += 1;
        });
        an = 0;
    }
};
request.send();