package com.blog.wsyServlet;

import com.blog.service.ClassificationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
    展示分类信息,webContent啥意思啊
 */
@WebServlet("/ClassificationDisplayServlet")
public class ClassificationDisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");         //消除乱码
        ClassificationService cS = new ClassificationService();
        List<Map<String,Object>> claAndNum = cS.getClassAndNumber();
        request.setAttribute("claAndNum",claAndNum);
        System.out.println(claAndNum);
       // response.sendRedirect(request.getContextPath() + "/WEB-INF/classification/classification.jsp");
        request.getRequestDispatcher("WEB-INF/classification/classification.jsp").forward(request,response);//页面无信息是因为缺少了相应的forward
    }
}
