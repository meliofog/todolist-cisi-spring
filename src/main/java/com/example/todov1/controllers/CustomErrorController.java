package com.example.todov1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Handle errors by redirecting to the home page
        return "redirect:/";
    }

    public String getErrorPath() {
        return "/error";
    }
}
