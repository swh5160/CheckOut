package com.neuedu.core;

import com.google.common.collect.Lists;
import com.neuedu.common.JwtUtil;
import com.neuedu.entity.Teacher;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.List;

/**
 * @author 施子安
 * @create
 *登录过滤器
 */
public class LoginFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    //内部接口集合
    public static List<String> INSIDE_URLS = Lists.newArrayList("/**","/login");
    //白名单接口集合
    public static List<String> WHITE_PATH = Lists.newArrayList("/teacher/login","/**");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse)servletResponse);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        if(INSIDE_URLS.contains(requestURI)){
            //内部接口，直接通过
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if(WHITE_PATH.contains(requestURI)){
            //白名单接口，直接通过
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //进行校验，如token校验
        String token = request.getHeader("token");
        System.out.println(token+"11111");
        Teacher teacher = JwtUtil.decode(token);

        if(teacher != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //token校验不通过，重定向到登录页面
            wrapper.sendRedirect("/");
        }
    }



    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
