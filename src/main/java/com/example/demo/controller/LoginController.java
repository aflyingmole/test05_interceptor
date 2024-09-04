package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";

    }
    @PostMapping("/member/login")
    public String login(String id, String pwd, HttpServletRequest req){
        if(id.equals("hello") && pwd.equals("1234")){
            req.getSession().setAttribute("id", id);
            return "redirect:/";
        }
        return "member/login";
    }

}
