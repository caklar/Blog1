package com.blog.servlet;

import com.alibaba.fastjson.JSONArray;
import com.blog.service.NewAndAlterArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/ClassFuzzyMatchServlet")
public class ClassFuzzyMatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String field = request.getParameter("class_tip");

        NewAndAlterArticleService get_cname_list = new NewAndAlterArticleService();
        String[] class_name_list;
        class_name_list = get_cname_list.get_class_name_list(field);

        JSONArray jsonArray=new JSONArray(Arrays.asList(class_name_list));
        System.out.println(jsonArray.toString());

//        for (int i=0; i<class_name_list.length; i++){
//            System.out.println(class_name_list[i]);
//        }

        PrintWriter out=response.getWriter();
        out.print(jsonArray.toString());
        out.close();


    }
}
