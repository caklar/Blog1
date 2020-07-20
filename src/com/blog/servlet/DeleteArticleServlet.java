package com.blog.servlet;

import com.blog.service.NewAndAlterArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
* @description: 获取id号删除文章
* @author: BIG_TRUCK li zonglin
**/
@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String article_id = request.getParameter("article_id");

        NewAndAlterArticleService deleteArticle = new NewAndAlterArticleService();

        int row;
        row = deleteArticle.delete_Article(Integer.parseInt(article_id));

        PrintWriter out = response.getWriter();
        out.print(row);
        out.close();

    }
}
