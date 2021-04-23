package com.qinh;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Qh
 * @Date 2021/4/23 15:10
 * @Version 1.0
 */
public class GetHtmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转发只能在工程里面跳转，转发可以跳转到WEB-INF下的资源
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form.html");
        dispatcher.forward(request,response);
    }
}
