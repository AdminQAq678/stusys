package com.wocnz.stusys.dao;

import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Course;
import com.wocnz.stusys.domain.TeasCourses;

import java.util.List;

public interface TeasCoursesDao {
    public List<TeasCourses> findAll();

    public Condition findAllByCon(Condition tcs);

    public boolean add(TeasCourses cou);

    public boolean del(String cno);

    public TeasCourses findByCno(String cno);

    public TeasCourses update(String cno, TeasCourses tcs );
}
