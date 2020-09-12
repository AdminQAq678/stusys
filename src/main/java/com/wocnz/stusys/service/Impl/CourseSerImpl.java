package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.CourseDao;
import com.wocnz.stusys.dao.impl.CourseDaoImpl;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Course;
import com.wocnz.stusys.service.CourseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseSerImpl implements CourseSer {
    @Autowired
    CourseDaoImpl courseDaoImpl;

    @Override
    public List<Course> findAllCou() {

        return  courseDaoImpl.findAllCou();
    }

    @Override
    public Condition findAllCouByCon(Condition con) {
        return courseDaoImpl.findAllStuByCon(con);
    }


    @Override
    public boolean addCourse(Course cou) {
        return courseDaoImpl.addCourse(cou);
    }

    @Override
    public boolean delCourse(String cno) {
        return courseDaoImpl.delCourse(cno);
    }

    @Override
    public Course findCourseByCno(String cno) {
        return courseDaoImpl.findCourseByCno(cno);
    }

    @Override
    public Course updateCourse(String cno, Course cou) {
        return courseDaoImpl.updateCourse(cno, cou);
    }
}
