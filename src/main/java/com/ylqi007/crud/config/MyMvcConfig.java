package com.ylqi007.crud.config;

import com.ylqi007.crud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // browser send localhost:8080/atguigu request, and then go to success.html
        registry.addViewController("/atguigu").setViewName("success");  // templates/success.html
        registry.addViewController("/").setViewName("login");   // templates/index.html
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}