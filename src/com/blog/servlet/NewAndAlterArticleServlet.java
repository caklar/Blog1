package com.blog.servlet;

import com.blog.service.NewAndAlterArticleService;
import net.sf.json.JSONObject;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();
        session.setAttribute("title", title);
        session.setAttribute("date", date);
        session.setAttribute("context", context);

        PrintWriter out=response.getWriter();
        out.print(row);
        out.close();
//
//        request.setAttribute("title", title);
//        request.setAttribute("date", date);
//        request.setAttribute("context", context);
//
//        request.getRequestDispatcher("views/article.jsp").forward(request, response);
//


    }
}
