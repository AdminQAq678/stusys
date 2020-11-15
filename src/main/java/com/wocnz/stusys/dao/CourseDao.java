package com.wocnz.stusys.dao;

import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Course;

import java.util.List;

public interface CourseDao {
    public List<Course> findAllCou();

    public Condition findAllStuByCon(Condition con);

    public boolean addCourse(Course cou);

    public boolean delCourse(String cno);

    public Course findCourseByCno(String cno);

    public Course updateCourse(String cno, Course cou );


}
