package com.blog.servlet;

import com.blog.service.NewAndAlterArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SetUpdateArticleInfoServlet")
public class SetUpdateArticleInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 从页面请求数据
        String a_id = request.getParameter("a_id");
        String title = request.getParameter("title");
        String ldate = request.getParameter("ldate");
        String content = request.getParameter("content");
        String contentmd = request.getParameter("contentMd");
        String cname = request.getParameter("cname");

        System.out.print("修改了页面");

        // 写入数据库
        NewAndAlterArticleService update_Article = new NewAndAlterArticleService();

        update_Article.update_Article(Integer.parseInt(a_id), title, ldate, content, contentmd, cname);



        PrintWriter out=response.getWriter();
        out.print(a_id);
        out.close();

        // 如果需要直接跳转到文章页面就加上，否则就不用了
//        HttpSession session = request.getSession();
//        session.setAttribute("title", title);
//        PrintWriter out=response.getWriter();
//        out.print();
//        out.close();


    }
}
