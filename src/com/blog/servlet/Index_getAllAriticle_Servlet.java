package com.blog.servlet;

import com.blog.service.ArticleInfoService_wsy;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Index_getAllAriticle_Servlet")
public class Index_getAllAriticle_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javascript;charset=utf-8");
        ArticleInfoService_wsy aisService = new ArticleInfoService_wsy();
        JSONArray jsonArray = aisService.findAll();
        response.getWriter().println(jsonArray);
    }
}
