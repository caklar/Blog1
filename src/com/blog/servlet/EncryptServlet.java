package com.blog.servlet;

import com.blog.service.EncryptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
* @description: double sha256
* @author: BIG_TRUCK li zonglin
**/
@WebServlet("/EncryptServlet")
public class EncryptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str = request.getParameter("token");
        System.out.println(str);
        boolean verified;
        PrintWriter out=response.getWriter();

        // 调用验证
        EncryptService verify = new EncryptService();
        verified = verify.double_SHA256(str);

        if(verified){
            out.print("1");
            out.close();
        }else {
            out.print("0");
            out.close();
        }



    }
}
