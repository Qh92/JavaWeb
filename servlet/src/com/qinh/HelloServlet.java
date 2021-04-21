package com.qinh;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-04-21-22:07
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init方法");

        //1.可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是: " + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("初始化参数username的值是: " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是: " + servletConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println("获取ServletContext对象: " + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.service 方法 Hello Servlet 被调用.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁方法");
    }
}
