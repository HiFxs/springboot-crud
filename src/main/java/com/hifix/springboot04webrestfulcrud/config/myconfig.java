package com.hifix.springboot04webrestfulcrud.config;

import com.hifix.springboot04webrestfulcrud.Interceptor.Loginhandleinceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class myconfig {
    @Bean
public  WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
registry.addViewController("/").setViewName("login");
registry.addViewController("/index.html").setViewName("login");
registry.addViewController("/main.html").setViewName("dashboard");


        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new Loginhandleinceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
        }
    };


return adapter;


}


}
