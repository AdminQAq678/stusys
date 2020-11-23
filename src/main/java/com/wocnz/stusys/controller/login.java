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

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


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
        if(userno.indexOf("stu")==-1){//不是学生登录
            System.out.println("老师或者管理员登录");
            Teacher t=teacherSer.findTeacherBytno(userno);
            if(t==null){

                System.out.println("无该用户，请联系管理员注册!");
                jsonObject.put("status",401);
                jsonObject.put("username","");
                jsonObject.put("token","");
                return  jsonObject.toString();
            }
            if(!t.getPasswd().equals(passwd)){
                System.out.println("账号或者密码输入错误，请重新输入!");
                jsonObject.put("status",402);
                jsonObject.put("username","");
                jsonObject.put("token","");
                return  jsonObject.toString();
            }
            jsonObject.put("status",200);
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
                System.out.println(userno);
                System.out.println("无该用户，请联系管理员注册!");
                jsonObject.put("status",401);
                jsonObject.put("username","");
                jsonObject.put("token","");
                return  jsonObject.toString();
            }
            if(!s.getPasswd().equals(passwd)){
//                System.out.println(s.getPasswd());
//                System.out.println(passwd);
                System.out.println("账号或者密码输入错误，请重新输入!");
                jsonObject.put("status",402);
                jsonObject.put("username","");
                jsonObject.put("token","");
                return  jsonObject.toString();
            }
            jsonObject.put("status",200);
            jsonObject.put("username",userno);
            jsonObject.put("token",TokenService.getToken(s));
            Cookie cookie=new Cookie("token",TokenService.getToken(s));
            response.addCookie(cookie);
            return  jsonObject.toString();
        }

    }
    @PostMapping("/getMenuList")
    public ArrayList<String> getMenuList (String uid){
        ArrayList<String> arrayList=new ArrayList<>();
        if(uid.indexOf("stu")!=-1){
            arrayList.add("/index");
            arrayList.add("el-icon-s-home");//图标
            arrayList.add("首页");
            arrayList.add("/sct");
            arrayList.add("iconfont icon-kecheng");//图标
            arrayList.add("学生已选课程");

//            arrayList.add("/course");
//            arrayList.add("iconfont icon-_huabanfuben");
//            arrayList.add("课程信息");

            arrayList.add("/selectCourse");
            arrayList.add("iconfont icon-xuanke");
            arrayList.add("选课");

        }else if(uid.indexOf("tea")!=-1){
            arrayList.add("/index");
            arrayList.add("el-icon-s-home");//图标
            arrayList.add("首页");

            arrayList.add("/course");
            arrayList.add("iconfont icon-_huabanfuben");
            arrayList.add("课程信息");


            arrayList.add("/teascourses");
            arrayList.add("iconfont icon-class");
            arrayList.add("我的授课");

        }else{
            arrayList.add("/index");
            arrayList.add("el-icon-s-home");//图标
            arrayList.add("首页");

            arrayList.add("/student");//学生
            arrayList.add("iconfont icon-xuesheng");//图标
            arrayList.add("学生信息");

            arrayList.add("/teacher");//老师
            arrayList.add("iconfont icon-laoshi");//图标
            arrayList.add("教师信息");

            arrayList.add("/department");//学院
            arrayList.add("iconfont icon-xueyuan");//图标
            arrayList.add("学院信息");

            arrayList.add("/sct");//学生已选课程
            arrayList.add("iconfont icon-kecheng");//图标
            arrayList.add("已选课程");

            arrayList.add("/course");//课程信息
            arrayList.add("iconfont icon-_huabanfuben");//图标
            arrayList.add("课程信息");

            arrayList.add("/selectCourse");//学生选课
            arrayList.add("iconfont icon-xuanke");//图标
            arrayList.add("学生选课");

            arrayList.add("/teascourses");//教师授课信息
            arrayList.add("iconfont icon-class");//图标
            arrayList.add("教师授课信息");

        }


        return arrayList;
    }



}
