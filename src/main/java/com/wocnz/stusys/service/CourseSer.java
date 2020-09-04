package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.Course;

import java.util.List;

public interface CourseSer {
    public List<Course> findAllCou();

    public boolean addCourse(Course cou);

    public boolean delCourse(String cno);

    public Course findCourseByCno(String cno);

    public Course updateCourse(String cno, Course cou );


}
