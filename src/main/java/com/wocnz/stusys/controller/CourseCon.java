package com.wocnz.stusys.controller;


import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Course;
import com.wocnz.stusys.service.Impl.CourseSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseCon {
    /**
     * 获取所有课程信息
     * @param sno
     * @return
     */


    @Autowired
    CourseSerImpl courseSerImpl;

    @RequestMapping("/findAllCou")
    public List<Course> findAllCou(){
        return courseSerImpl.findAllCou();
    }

    /**
     * 根据课程号查询课程信息
     * @param cno
     * @return Course
     */
    @RequestMapping(value = "/course/{cno}",method = RequestMethod.GET)
    public Course findCourseById(@PathVariable("cno") String cno){
        System.out.println(cno);
        System.out.println("get");
        return courseSerImpl.findCourseByCno(cno);
    }

    /**
     * 根据学号更新学生信息
     * @param cno 要修改课程的课程号
     * @param cou 该课程的新信息
     * @return
     */
    @RequestMapping(value = "/course/{cno}",method = RequestMethod.PUT)
    public Course updateCourse(@PathVariable("cno") String cno,@RequestBody Course cou){
        System.out.println(cno);
        System.out.println(cou);
        System.out.println("update");


        return  courseSerImpl.updateCourse(cno,cou);
    }
    /**
     * 新增学生生信息
     *
     * @param cou
     * @return
     */
    @RequestMapping(value = "/course",method = RequestMethod.POST)
    public ArrayList<Course> addCourse(@RequestBody Course cou){
        System.out.println("add");
        courseSerImpl.addCourse(cou);
        return null;
    }
    /**
     * 根据cno查询课程信息
     *
     * @param cno
     * @return null
     */
    @RequestMapping(value = "/course/{cno}",method = RequestMethod.DELETE)
    public boolean delCourse(@PathVariable("cno") String  cno){


        return  courseSerImpl.delCourse(cno);
    }

    @RequestMapping(value = "/findCourseByCon",method = RequestMethod.GET)
    public Condition findStudentByCon(Condition con){

        return courseSerImpl.findAllCouByCon(con);

    }


}
