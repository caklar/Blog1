package com.blog.servlet;

import com.blog.service.NewAndAlterArticleService;
import com.blog.service.comment_info_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/new_comment_Servlet")
public class new_comment_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("remark_name");
        String context = request.getParameter("remark_context");
        String aid = request.getParameter("remark_aid");
        String date = request.getParameter("remark_date");

        System.out.println(name+"be in servlet");

        comment_info_Service comment=new comment_info_Service();

        int row = comment.dosave(name,context,aid,date);


        // 得到最大 remarkid
        NewAndAlterArticleService mrid = new NewAndAlterArticleService();
        int M_Rid =  mrid.get_Max_remarkid();



        PrintWriter out=response.getWriter();
        out.print(M_Rid);
        out.close();
    }
}
