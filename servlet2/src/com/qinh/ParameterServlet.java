package com.qinh;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 获取请求参数
 *
 * @Author Qh
 * @Date 2021/4/23 14:47
 * @Version 1.0
 */
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------doPost------------");
        // 设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        // 也要在获取请求参数之前调用才有效
        request.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------doGet------------");

        // 获取请求参数
        String username = request.getParameter("username");
        //1 先以iso8859-1进行编码
        //2 再以utf-8进行解码
        //username = new String(username.getBytes("iso-8859-1"), "UTF-8");

        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }
}
