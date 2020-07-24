package com.blog.servlet;

import com.blog.service.comment_info_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/comment_del_Servlet")
public class comment_del_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("remark_id");

        System.out.println(id);

        comment_info_Service comment=new comment_info_Service();
        int row = comment.dodel(id);

        PrintWriter out=response.getWriter();
        out.print(row);
        out.close();

    }
}
