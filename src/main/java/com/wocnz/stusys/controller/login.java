package com.wocnz.stusys.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class login {

    @RequestMapping("/login")
    public String login(){
        System.out.println("login.html");
        return "login";
    }


}
