$("#archive").click(function(){
    /*$.ajax({url:"Servlet",success:function(result){
            alert(result);
        }});*/
    $.ajax({
        type: 'POST',
        url: 'Index_getAllAriticle_Servlet',
        data: {},
        dataType:"JSON",
        success: function(result,msg){
            //alert(msg);
            //alert(dat.dataa);
            alert(result);
            //[{"a_cid":1,"a_date":"2020-8-7","a_id":1,"a_context":"我的第一篇文章","a_ldate":"2009-12-3","a_title":"123","a_view":null,"a_del":0}]
            //遍历list
            var html = "";
            for(var i = 0;i<result.length;i++){
                html+="<li><span>"+result[i].a_date+"</span><br><span>"+result[i].a_title+"</span><br/></li>";
            }
            $("#main").html(html);

        },
        error:function(xhr,errorMsg,error){
            alert(xhr.status);
            alert(errorMsg);//console.log();
        }
    });

});

$("#classification").click(function(){
    $.ajax({
        type: 'POST',
        url: 'Index_getAllAriticle_Servlet',
        data: {},
        dataType:"JSON",
        success: function(result,msg){
            alert(result);
            //[{"a_cid":1,"a_date":"2020-8-7","a_id":1,"a_context":"我的第一篇文章","a_ldate":"2009-12-3","a_title":"123","a_view":null,"a_del":0}]
            //遍历list
            var html = "";
            for(var i = 0;i<result.length;i++){
                html+="<li><span>"+result[i].a_date+"</span><br><span>"+result[i].a_title+"</span><br/></li>";
            }
            $("#main").html(html);
        },
        error:function(xhr,errorMsg,error){
            alert(xhr.status);
            alert(errorMsg);//console.log();
        }
    });

});