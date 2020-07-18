package com.blog.servlet;

import com.blog.service.NewAndAlterArticleService;
import net.sf.json.JSONObject;


import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/NewAndAlterArticleServlet")

public class NewAndAlterArticleServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //doGet(request, response);
//        String title = request.getParameter("title");
//        String date = request.getParameter("date");
//        String context = request.getParameter("content");
//        String cname = request.getParameter("cname");
//
//        NewAndAlterArticleService newAndAlterArticleService = new NewAndAlterArticleService();
//
//        int row = newAndAlterArticleService.createArticle(title, date, context, cname);
//
//        PrintWriter out=response.getWriter();
//        out.print(row);
//        out.close();
        response.setContentType("text/html;charset=utf-8");
//把基础类型的数据变成jon
        JSONObject json = new JSONObject();
        json.put("tom", "账号或密码错误");
        json.put("zs","张三");
        json.put("lis","李四");
        response.getWriter().println(json);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request, response);

    }
}
