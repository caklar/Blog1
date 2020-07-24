package com.blog.servlet;

import com.blog.service.GetOneArticleService;
import com.blog.service.NewAndAlterArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @description: 对现有文章进行修改
* @author: BIG_TRUCK li zonglin
**/
@WebServlet("/GetUpdateArticleInfoServlet")
public class GetUpdateArticleInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        // 先获得请求的id
        String article_id = request.getParameter("article_id");

        // 从后台获取文章数据
        List<Map<String, Object>> article_info = null;
        GetOneArticleService getOneArticleService = new GetOneArticleService();
        article_info = getOneArticleService.get_One_Article(Integer.parseInt(article_id));

        Map<String, Object> info = article_info.get(0);

        //String date;
        String title;
        String content;
        String cname;


        // 先处理标题&文章内容&日期
        title = (String) info.get("a_title");
        content = (String) info.get("a_context_md");
        // date = (String) info.get("a_date");


        // 再处理分类名字， 根据 class_id 查 class_name
        int c_id = (int) info.get("a_cid");
        NewAndAlterArticleService getclassname = new NewAndAlterArticleService();

        cname = getclassname.get_class_name(c_id);

        // 都处理完后向 updateArticle 页面写数据
        request.setAttribute("a_id", article_id);
        request.setAttribute("title", title);
        request.setAttribute("cname", cname);
        request.setAttribute("content", content);

        // 转发请求
        request.getRequestDispatcher("views/updataArticle.jsp").forward(request, response);





    }
}
