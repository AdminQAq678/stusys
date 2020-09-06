package com.wocnz.stusys.controller;


import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.Impl.TeacherSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class teachercon {
    @Autowired
    TeacherSerImpl teaSerImpl;

    /**
     * 获取所有老师
     * @param tno
     * @return
     */
    @RequestMapping("/findAllTea")
    public List<Teacher> findAll(@PathParam("tno") String tno){
        return  teaSerImpl.findAllTea();

    }

    /**
     * 根据教师编号号查询老师信息
     * @param tno
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.GET)
    public Teacher findStudentById(@PathVariable("tno") String tno){

        return teaSerImpl.findStudentBytno(tno);
    }

    /**
     * 根据学号更新老师信息
     * @param tno 要修改学生的学号
     * @param tea 该学生的新信息
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.PUT)
    public Teacher updateStudent(@PathVariable("tno") String tno,@RequestBody Teacher tea){

        return teaSerImpl.updateTeacher(tno,tea);
    }
    /**
     * 新增老师信息
     *
     * @param tea
     * @return
     */
    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public boolean addStudent( @RequestBody Teacher tea){

        return teaSerImpl.addTeacher(tea);
    }
    /**
     * 根据tno查询老师信息
     *
     * @param tno
     * @return
     */
    @RequestMapping(value = "/teacher/{tno}",method = RequestMethod.DELETE)
    public boolean delStudent(@PathVariable("tno") String tno){
        return teaSerImpl.delTeacher(tno);
    }


}
