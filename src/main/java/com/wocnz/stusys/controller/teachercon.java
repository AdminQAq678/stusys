package com.wocnz.stusys.controller;

import com.wocnz.stusys.domain.student;
import com.wocnz.stusys.domain.teacher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
public class teachercon {
    /**
     * 获取所有老师
     * @param tno
     * @return
     */
    @RequestMapping("/getAllTea")
    public ArrayList<teacher> findAll(@PathParam("tno") String tno){
        System.out.println(tno);
        System.out.println("tno");
        return null;
    }

    /**
     * 根据教师编号号查询老师信息
     * @param tno
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.GET)
    public ArrayList<teacher> findStudentById(@PathVariable("tno") String tno){
        System.out.println(tno);
        System.out.println("get");
        return null;
    }

    /**
     * 根据学号更新老师信息
     * @param tno 要修改学生的学号
     * @param tea 该学生的新信息
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.PUT)
    public ArrayList<teacher> updateStudent(@PathVariable("tno") String tno, teacher tea){
        System.out.println(tno);
        System.out.println(tea);
        System.out.println("update");
        return null;
    }
    /**
     * 新增老师信息
     *
     * @param tea
     * @return
     */
    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public ArrayList<teacher> addStudent( teacher tea){
        System.out.println("add");
        return null;
    }
    /**
     * 根据tno查询老师信息
     *
     * @param tno
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.DELETE)
    public ArrayList<teacher> delStudent(@PathVariable("tno") String tno){
        System.out.println("deltno");
        return null;
    }


}
