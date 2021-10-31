package com.qinh.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Qh
 * @version 1.0
 * @date 2021-10-31 14:06
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1的前置代码");
        System.out.println("Filter1的前置线程名: " + Thread.currentThread().getName());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter1的后置线程名: " + Thread.currentThread().getName());
        System.out.println("Filter1的后置代码");
    }

    @Override
    public void destroy() {

    }
}
