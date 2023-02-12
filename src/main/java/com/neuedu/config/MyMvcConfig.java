package com.neuedu.config;


import com.neuedu.core.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor setBean(){
        return new LoginInterceptor();
    }
    @Override
    //通过此处加载拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(setBean())
                // 拦截路径
                .addPathPatterns("/**")
//                .excludePathPatterns("/teacher/list");
                // 排除路径
                .excludePathPatterns("/asset/**","/teacher/list","/img/**","/js/**");
    }
}