package com.qinh;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Qh
 * @Date 2021/4/23 9:38
 * @Version 1.0
 */
public class ContextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        //1、获取web.xml中配置的上下文参数context-param
        String username = context.getInitParameter("username");
        // root
        System.out.println(username);
        String url = context.getInitParameter("url");
        // jdbc:mysql://localhost:3306/test
        System.out.println(url);

        //2、获取当前的工程路径，格式: /工程路径
        String contextPath = context.getContextPath();
        // /servlet
        System.out.println(contextPath);

        //3、获取工程部署后在服务器硬盘上的绝对路径
        /**
         *  / 斜杠被服务器解析地址为:http://ip:port/工程名/  映射到IDEA代码的web目录<br/>
         */
        // E:\item\JavaWeb\JavaWeb\out\artifacts\
        System.out.println("工程部署的路径是:" + context.getRealPath("/"));
        System.out.println("工程下css目录的绝对路径是:" + context.getRealPath("/css"));
        System.out.println("工程下imgs目录1.jpg的绝对路径是:" + context.getRealPath("/imgs/1.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
