package com.blog.servlet;

import com.blog.service.NewAndAlterArticleService;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


/**
* @description: 新建文章/修改文章
* @author: BIG_TRUCK li zonglin
**/
@WebServlet("/NewAndAlterArticleServlet")

public class NewAndAlterArticleServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String context = request.getParameter("content");
        String cname = request.getParameter("cname");

        System.out.println(title+"in servlet");

        NewAndAlterArticleService newAndAlterArticleService = new NewAndAlterArticleService();

        int row = newAndAlterArticleService.createArticle(title, date, context, cname);
        PrintWriter out=response.getWriter();
        out.print(row);
        out.close();
    }
}
