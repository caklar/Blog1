<%--
  Created by IntelliJ IDEA.
  User: 15P-5545
  Date: 2020/7/19
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    /*body{
        color: red;
        background-color: #00FF00;
    }*/
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="items" items="${articles}">
        <tr>
            <td><span class=".article">${items.a_id}</span></td>
            <td>${items.a_title}</td>
            <td>${items.a_ldate}</td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    $(document).on("click", ".article", function (e) {
        //$(this)或者$(e.target)获取当前元素


        //alert($(this).html())
        // alert(event.)
        var a_id=$(this).html();
        //alert(classId);
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/GetOneArticleServlet?class_id='+a_id,
            data: {},
            dataType:"html",
            success: function(result,msg){
                //alert(result);
                var html = "";
                $("#main").html(result);
            },
            error:function(xhr,errorMsg,error){
                alert(xhr.status);
                alert(errorMsg);//console.log();
            }
        });
    })
</script>
</html>
