package com.wocnz.stusys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class login {
    @RequestMapping("/login")
    public Boolean login(){
        System.out.println("login.html");
        return true;
    }
}
