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

    /**
     * 查询教师的所有授课信息
     * @return
     */
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

    /**
     * 根据课程号更新教师授课信息
     * @param cno
     * @param tsc
     * @return
     */
   @RequestMapping(value = "/tsc/{cno}",method = RequestMethod.PUT)
    public TeasCourses update(@PathVariable("cno") String cno, @RequestBody TeasCourses tsc){

        return teasCoursesDao.update(cno,tsc);
    }

    /**
     * 添加教师授课信息
     * @param tsc
     * @return
     */
    @RequestMapping(value = "/tsc",method = RequestMethod.POST)
    public boolean add( @RequestBody TeasCourses tsc){

        return teasCoursesDao.add(tsc);
    }

    /**
     * 根据课程号删除教师授课信息
     * @param cno
     * @return
     */
    @RequestMapping(value = "/tsc/{cno}",method = RequestMethod.DELETE)
    public boolean del(@PathVariable("cno") String cno){
        return teasCoursesDao.del(cno);
    }

    /**
     * 分页查询教师授课信息
     * @param con
     * @return
     */
    @RequestMapping(value = "/findTscByCon",method = RequestMethod.GET)
    public Condition findTscByCon(Condition con){

        return teasCoursesDao.findAllByCon(con);

    }
}
