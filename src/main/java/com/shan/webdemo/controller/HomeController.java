package com.shan.webdemo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";  // 返回 index.html 模板
    }

    @GetMapping("/api/home")
    @ResponseBody  // 因為這是 API 呼叫
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to the secure home page!");
        response.put("timestamp", new Date());
        response.put("status", "success");
        return response;
    }
}
