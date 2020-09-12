package com.wocnz.stusys.controller;

import com.wocnz.stusys.utils.AiFunc;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
public class login {
    @RequestMapping("/login")
    public Boolean login(){
        System.out.println("login.html");
        return true;
    }
    @Autowired
    AiFunc aiFunc;
    @RequestMapping(value = "/uploadFile" , method = RequestMethod.POST)
    public String upload( MultipartFile file) throws IOException {
        aiFunc.diffFace(file,"001","admin",null);
        return "";
    }

    @RequestMapping(value = "/up" , method = RequestMethod.POST)
    public String up( String imgurl) throws IOException {
        System.out.println(imgurl);
        System.out.println(imgurl.substring(22));
        JSONObject jsonObject=aiFunc.diffFace(imgurl.substring(22),"001","admin",null);
        return "人脸对比结果:相似度"+jsonObject.getInt("score")+"%";
    }
}
