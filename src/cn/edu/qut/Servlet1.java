package cn.edu.qut;

import net.sf.json.JSONArray;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javascript;charset=utf-8");
        Map<String,String> m = new HashMap<String,String>();
        m.put("name","小明");
        m.put("age","18");

        Map<String,String> m1 = new HashMap<String,String>();
        m1.put("name","小红");
        m1.put("age","19");

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        list.add(m);
        list.add(m1);
        JSONArray jsonArray = JSONArray.fromObject(list);
        //System.out.println(jsonArray);
        response.getWriter().println(jsonArray);

    }
    @Test
    public void a(){
        System.out.println(123);
    }
}
