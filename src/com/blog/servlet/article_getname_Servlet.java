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

@WebServlet("/index")
public class article_getname_Servlet extends HttpServlet {
    public article_getname_Servlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(200);

        PrintWriter out=response.getWriter();
        article_info_Service re = new article_info_Service();
        List<Map<String, Object>> list = re.Find_exhibit_info_2();;
        //HttpSession session =request.getSession();
        //session.setAttribute("class_info_test", list);
        //response.sendRedirect("class_info.jsp");
        //System.out.println(list);
        String[] key_info= new String[]{"a_title", "a_ldate", "a_context_md","a_id"};
        Object[] value_info=new Object[4];
        StringBuilder sentence= new StringBuilder("[");
        for(int i=0;i<list.size();i++){
            Map<String,Object> map=list.get(i);
            for(int j=0;j<4;j++) {
                value_info[j] = map.get(key_info[j]);
            }
            if(i==list.size()-1) {
                String str = (String) value_info[2];
                String reg = "[^\u4e00-\u9fa5,，.。0-9a-zA-Z]";
                //String reg = "[^\u4e00-\u9fa5]|[^(,|，|.|。)]";
                str = str.replaceAll(reg, "");
                System.out.println(str);
                sentence.append("{\"title\":\"").append(value_info[0]).append("\",\"ldate\":\"").append(value_info[1]).append("\",\"article_preview\":\"").append(str).append("\",\"article_id\":\"").append(value_info[3]).append("\"}");
            }
            else {
                String str = (String) value_info[2];
                //String reg = "[^\u4e00-\u9fa5]|[^(,|，|.|。)]";
                String reg = "[^\u4e00-\u9fa5,，.。0-9a-zA-Z]";
                str = str.replaceAll(reg, "");
                System.out.println(str);
                sentence.append("{\"title\":\"").append(value_info[0]).append("\",\"ldate\":\"").append(value_info[1]).append("\",\"article_preview\":\"").append(str).append("\",\"article_id\":\"").append(value_info[3]).append("\"},");
            }
        }
        sentence.append("]");
        System.out.println(sentence);
        out.print(sentence);

    }
}
