package com.wocnz.stusys.controller;

import com.wocnz.stusys.domain.student;
import com.wocnz.stusys.service.Impl.studentSerImpl;
import com.wocnz.stusys.service.studentSer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class studentCon {
    /**
     * 获取所有学生信息
     * @param sno
     * @return
     */

    @Autowired
    studentSer ser;
    @Autowired
    studentSerImpl stuSerImpl;

    @RequestMapping("/findAllStu")
    public List<student> findAllStu(){


        return stuSerImpl.findAllStu();
    }

    /**
     * 根据学号查询学生信息
     * @param sno
     * @return
     */
    @RequestMapping(value = "/student/{sno}",method = RequestMethod.GET)
    public student findStudentById(@PathVariable("sno") String sno){
        System.out.println(sno);
        System.out.println("get");
        return stuSerImpl.findStudentBySno(sno);
    }

    /**
     * 根据学号更新学生信息
     * @param sno 要修改学生的学号
     * @param stu 该学生的新信息
     * @return
     */
    @RequestMapping(value = "/student/{sno}",method = RequestMethod.PUT)
    public student updateStudent(@PathVariable("sno") String sno,student stu){
        System.out.println(sno);
        System.out.println(stu);
        System.out.println("update");


        return  stuSerImpl.updateStudent(sno,stu);
    }
    /**
     * 新增学生生信息
     *
     * @param stu
     * @return
     */
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ArrayList<student> addStudent( student stu){
        System.out.println("add");
        stuSerImpl.addStudent(stu);
        return null;
    }
    /**
     * 根据sno查询学生信息
     *
     * @param sno
     * @return
     */
    @RequestMapping(value = "/student/{sno}",method = RequestMethod.DELETE)
    public ArrayList<student> delStudent(@PathVariable("sno") String  sno){
        if(stuSerImpl.delStudent(sno)){
            System.out.println("删除学生信息成功");
        };
        return null;
    }


}
