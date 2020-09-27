package com.wocnz.stusys.controller;

import com.wocnz.stusys.awt.TokenService;
import com.wocnz.stusys.dao.impl.TeacherDaoImpl;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.Impl.StudentSerImpl;
import com.wocnz.stusys.service.Impl.TeacherSerImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录接口
 */
@RestController
public class login {
    @Autowired
    TeacherSerImpl teacherSer;

    @Autowired
    StudentSerImpl studentSer;

    @RequestMapping("/login")
    public String login(HttpServletResponse response,String userno, String passwd){
        JSONObject jsonObject=new JSONObject();
        System.out.println("欢迎登录");
        System.out.println(userno+passwd);
        System.out.println(userno.substring(2));
        if(userno.substring(0,2).equals("66")){
            System.out.println("老师登录");
            Teacher t=teacherSer.findTeacherBytno(userno);
            if(t==null){
                System.out.println("教师编号输入错误，请重新输入");
                return "教师编号输入错误，请重新输入";
            }
            if(!t.getPasswd().equals(passwd)){
                System.out.println("教师登录密码输入错误，请重新输入");
                return "教师登录密码输入错误，请重新输入";
            }
            jsonObject.put("status","ok");
            jsonObject.put("username",userno);
            jsonObject.put("token",TokenService.getToken(t));
            Cookie cookie=new Cookie("token",TokenService.getToken(t));
            response.addCookie(cookie);
            return  jsonObject.toString();

        }else{
            System.out.println("学生登录");

            Student s=studentSer.findStudentBySno(userno);
            System.out.println(s);
            if(s==null){
                System.out.println("学号输入错误，请重新输入");
                return "学号输入错误，请重新输入";
            }
            if(!s.getPasswd().equals(passwd)){
                System.out.println(s.getPasswd());
                System.out.println(passwd);
                System.out.println("密码输入错误，请重新输入");
                return "密码输入错误，请重新输入";
            }
            jsonObject.put("status","ok");
            jsonObject.put("username",userno);
            jsonObject.put("token",TokenService.getToken(s));
            Cookie cookie=new Cookie("token",TokenService.getToken(s));
            response.addCookie(cookie);
            return  jsonObject.toString();
        }

    }


}
