package com.blog.wsyServlet;

import com.blog.service.ArticleInfoService_wsy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/*
    返回某一类别的文章信息
 */
@WebServlet("/ClassificationGetArticlesServlet")
public class ClassificationGetArticlesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String class_id = request.getParameter("class_id");
        System.out.println(class_id);
        ArticleInfoService_wsy aISs = new ArticleInfoService_wsy();
        List<Map<String,Object>> articles = aISs.getArticleOfClass(class_id);
        request.setAttribute("articles",articles);
        request.getRequestDispatcher("WEB-INF/classification/articleOfClass.jsp").forward(request,response);
    }
}
