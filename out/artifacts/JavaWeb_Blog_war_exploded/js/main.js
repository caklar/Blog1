
$('.content').find('ul').append(`
        <li>
                <div class="article_title">
                    article
                </div>
    
                <div class="article_pre">
                    article_preview
                </div>

                <div>
                    新加的文章
                </div>
                
                <p>
                    <button class="read_button">
                        READ MORE
                    </button>
                </p>
        </li>
`);


getCSS.onclick = () => {
    const request = new XMLHttpRequest();
    request.open('GET','js/d.json');
    request.onload = ()=>{
        console.log('success');
        console.log("request.response");
        console.log(request.response)
        const xObject = JSON.parse(request.response);
        console.log(xObject);
    }
    request.onerror = ()=>{
        console.log('fail');
    }
    request.send();
}

