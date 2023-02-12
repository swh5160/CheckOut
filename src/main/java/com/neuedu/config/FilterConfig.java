package com.neuedu.config;

import com.google.common.collect.Lists;
import com.neuedu.core.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

/**
 * @author 施子安
 * @create
 */
//@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean myFilterRegistrationBean(){
        System.out.println("这里是过滤器bean");
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new LoginFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;

        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.setUrlPatterns(Lists.newArrayList("/*"));
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
