package com.qinh;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * requestAPI
 *
 * @Author Qh
 * @Date 2021/4/23 14:57
 * @Version 1.0
 */
public class RequestAPIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        i.getRequestURI()					获取请求的资源路径
        System.out.println("请求资源路径 : " + request.getRequestURI());
//        ii.getRequestURL()					获取请求的统一资源定位符（绝对路径）
        System.out.println("请求的统一资源定位符 : " + request.getRequestURL());
//        iii.getRemoteHost()				获取客户端的ip地址
        /**
         * 在IDEA中，使用localhost访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用127.0.0.1访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用 真实ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址<br/>
         */
        System.out.println("客户端的ip地址 : " + request.getRemoteHost());
//        iv.getHeader()						获取请求头
        System.out.println("请求头 : " + request.getHeader("User-Agent"));
//        vii.getMethod()					获取请求的方式GET或POST
        System.out.println("请求方式 : " + request.getMethod());
    }
}
