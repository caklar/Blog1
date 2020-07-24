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
        String context_md = request.getParameter("contentMd");
        String cname = request.getParameter("cname");

        //System.out.println(title+"in servlet");

        NewAndAlterArticleService newAndAlterArticleService = new NewAndAlterArticleService();

        // 查 id
        int a_id;

        int row = newAndAlterArticleService.createArticle(title, date, context, context_md,cname);

        a_id = newAndAlterArticleService.get_max_id();

        PrintWriter out=response.getWriter();
        out.print(a_id);
        out.close();
//
//        request.setAttribute("title", title);
//        request.setAttribute("date", date);
//        request.setAttribute("context", context);
//
//        request.getRequestDispatcher("views/article.jsp").forward(request, response);
//
///
//        HttpSession session = request.getSession();
//        session.setAttribute("title", title);
//        session.setAttribute("date", date);
//        session.setAttribute("context", context);
    }
}
