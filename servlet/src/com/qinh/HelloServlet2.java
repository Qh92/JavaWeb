package com.qinh;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-04-21-23:25
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //不加super.init(config);会出现异常
        super.init(config);
        System.out.println("初始化工作......");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doGet方法");
        //也可以使用
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        System.out.println("初始化参数username的值是: " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是: " + servletConfig.getInitParameter("url"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost方法");
    }
}
