package com.wocnz.stusys.controller;

import com.wocnz.stusys.dao.impl.TeasCoursesDaoImpl;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.domain.TeasCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeasCoursesCon {
    @Autowired
    TeasCoursesDaoImpl teasCoursesDao;


    @RequestMapping("/findAllTsc")
    public List<TeasCourses> findAll(){
        return  teasCoursesDao.findAll();

    }

    /**
     * 根据课程号查询授课信息
     * @param cno
     * @return
     */
    @RequestMapping(value = "/tsc/{cno}",method = RequestMethod.GET)
    public TeasCourses findStudentById(@PathVariable("cno") String cno){

        return teasCoursesDao.findByCno(cno);
    }


   @RequestMapping(value = "/tsc/{cno}",method = RequestMethod.PUT)
    public TeasCourses update(@PathVariable("cno") String cno, @RequestBody TeasCourses tsc){

        return teasCoursesDao.update(cno,tsc);
    }

    @RequestMapping(value = "/tsc",method = RequestMethod.POST)
    public boolean add( @RequestBody TeasCourses tsc){

        return teasCoursesDao.add(tsc);
    }


    @RequestMapping(value = "/tsc/{cno}",method = RequestMethod.DELETE)
    public boolean del(@PathVariable("cno") String cno){
        return teasCoursesDao.del(cno);
    }

    @RequestMapping(value = "/findTscByCon",method = RequestMethod.GET)
    public Condition findTscByCon(Condition con){

        return teasCoursesDao.findAllByCon(con);

    }
}
