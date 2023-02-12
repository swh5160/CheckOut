package com.neuedu.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.common.JwtUtil;
import com.neuedu.common.ResultJson;
import com.neuedu.entity.Teacher;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 施子安
 * @create
 */


public class LoginInterceptor implements HandlerInterceptor  {

    @Autowired
    private White white;
    @Resource
    ObjectMapper objectMapper;
    public static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 在请求被处理之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String uri = request.getRequestURI();

        //转换编码
//        URLEncoder.encode(request.getRequestURI(), StandardCharsets.ISO_8859_1.name());
       /* System.out.println("地址"+request.getRequestURL());
        System.out.println("token-----"+token);
        //增加一个loginId参数，让controller能够获取知道请求的认识谁

        System.out.println("servletPath:"+request.getServletPath());
        System.out.println("contextPath:"+request.getContextPath());
        System.out.println("contextPath2:"+request.getServletContext().getContextPath());
        System.out.println("pageInfo:"+request.getPathInfo());
        System.out.println("uri:"+request.getRequestURI());
        System.out.println("url:"+request.getRequestURL());
        System.out.println("realPath:"+request.getServletContext().getRealPath("/"));
*/
//        System.out.println(request.getContextPath());
        if (token != null){
            Teacher teacher = JwtUtil.decode(token);
            System.out.println(teacher.getId());
        }
        //拿到权限列表

        //创建地址匹配工具
        AntPathMatcher pathMatcher = new AntPathMatcher();
        System.out.println(request.getRequestURI());
        //如果一个都没匹配到，没有权限匹配到
        ResultJson.forBig("该用户没有权限");

//        //这里是ok
//        String token = request.getHeader("token");
//        System.out.println("地址"+request.getRequestURI());
//        System.out.println("token-----"+token);
//        if (token != null){
//            Teacher teacher = JwtUtil.decode(token);
//            if(teacher != null){
//
//                System.out.println(objectMapper.writeValueAsString(ResultJson.unauto("登录成功")));
//                return true;
//            }
//        }
//
//
//        System.out.println(objectMapper.writeValueAsString(ResultJson.unauto("登录失败")));
//        return false;
        return true;



    }


    /**
     * 在请求被处理后，视图渲染之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }


    /**
     * 在整个请求结束后调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}

