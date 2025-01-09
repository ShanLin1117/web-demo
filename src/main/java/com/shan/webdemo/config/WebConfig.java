package com.shan.webdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 將根路徑導向到登入頁面
        registry.addViewController("/").setViewName("redirect:/login.html");
        // 添加登入頁面的視圖控制器
        registry.addViewController("/login.html").setViewName("login");
    }
}