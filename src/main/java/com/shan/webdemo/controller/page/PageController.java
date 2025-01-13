package com.shan.webdemo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        // 重定向到登入頁
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";  // 返回 login.html
    }
    
    @GetMapping("/home")
    public String home() {
        return "index";  // 返回 index.html
    }
}
