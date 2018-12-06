package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by admin on 22.11.2018.
 */
@Controller
public class LoginController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/employee")
    public String showPageAfterLogin(){
        return "logged-page";
    }

    @GetMapping("/showLoginForm")
    public String loginForm(){
        return "fancy-login";
    }

    @GetMapping("/assistants")
    public String assistansPage(){
        return "assistant-page";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "access-denied-page";
    }
}
