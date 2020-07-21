package com.blog.servlet;

import com.alibaba.fastjson.JSON;
import com.blog.service.GetOneArticleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/GetOneArticleServlet_wsy")
public class GetOneArticleServlet_wsy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");


        // 先获得请求的id
        String article_id = request.getParameter("article_id");

        // 从后台获取文章数据
        List<Map<String, Object>> article_info = null;
        GetOneArticleService getOneArticleService = new GetOneArticleService();
        article_info = getOneArticleService.get_One_Article(Integer.parseInt(article_id));

        Map<String, Object> info = article_info.get(0);

//        String json_info = JSON.toJSONString(info);
////        PrintWriter pw = response.getWriter();
////        pw.write(json_info);

        String title;
        String date;
        String context;

        title = (String) info.get("a_title");
        date = (String) info.get("a_date");
        context = (String) info.get("a_context");

        request.setAttribute("title", title);
        request.setAttribute("date", date);
        request.setAttribute("content", context);


        request.getRequestDispatcher("views/article_wsy.jsp").forward(request, response);

    }
}