package com.wocnz.stusys.controller;

import com.wocnz.stusys.domain.ClassInfo;

import com.wocnz.stusys.service.Impl.ClassInfoSerImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 显示学生已选课程类
 */
@RestController
public class ClassInfoCon {

    @Autowired
    ClassInfoSerImpl classInfoSerImpl;

    /**
     * 查询所有已选课程
     * 学生已选课程信息接口
     * @return
     */
    @RequestMapping("/findAllClInfo")
    public List<ClassInfo> findAllClInfo(){
        return classInfoSerImpl.findAllClInfo();
    }


    /**
     * 查询教师授课信息，同时连接course表和teacher表进行显示
     * 显示选课信息接口
     * @return
     */
    @RequestMapping("/findStuTeasCourse")
    public List<ClassInfo> findStuTeasCourse(){
        return  classInfoSerImpl.findTeasCourse();

    }





}
