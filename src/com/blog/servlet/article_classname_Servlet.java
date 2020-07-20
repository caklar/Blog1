package com.blog.servlet;

import com.blog.service.article_info_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/article_classname_Servlet")
public class article_classname_Servlet extends HttpServlet {
    public article_classname_Servlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        article_info_Service re = new article_info_Service();
        List<Map<String, Object>> list = re.Find_class_info();;
        HttpSession session =request.getSession();
        session.setAttribute("class_info_test", list);
//        response.sendRedirect("class_info.jsp");
        request.getRequestDispatcher("class_info.jsp").forward(request,response);
        return;
    }
}
