package cn.edu.qut;

import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("hello");

        response.setContentType("text/html;charset=utf-8");
//把基础类型的数据变成jon
        JSONObject json = new JSONObject();
        json.put("tom", "账号或密码错误");
        json.put("zs","张三");
        json.put("lis","李四");
        response.getWriter().println(json);

    }
}
