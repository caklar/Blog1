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

        },
        error:function(xhr,errorMsg,error){
            alert(xhr.status);
            alert(errorMsg);//console.log();
        }
    });

});