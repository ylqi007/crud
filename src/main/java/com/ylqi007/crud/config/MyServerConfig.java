package com.ylqi007.crud.config;

import com.ylqi007.crud.filter.MyFilter;
import com.ylqi007.crud.listener.MyListener;
import com.ylqi007.crud.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

    // 配置嵌入是 Servlet 容器的
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }

    // 注册三大组件
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        ServletRegistrationBean<MyServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        servletServletRegistrationBean.setLoadOnStartup(1);
        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener() {
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return servletListenerRegistrationBean;
    }
}
