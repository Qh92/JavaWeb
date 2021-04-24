package com.qinh;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-04-24-12:33
 */
public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("曾到此一游 Response1 ");

        request.setAttribute("key1", "value1");

        // 设置响应状态码302 ，表示重定向，（已搬迁）
//        response.setStatus(302);
        // 设置响应头，说明 新的地址在哪里
//        response.setHeader("Location", "http://localhost:8080/servlet2/response2");
//        response.setHeader("Location", "http://localhost:8080");

        response.sendRedirect("/servlet2/response2");
    }
}
