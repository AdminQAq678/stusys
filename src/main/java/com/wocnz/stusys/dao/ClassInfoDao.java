package com.wocnz.stusys.dao;

import com.wocnz.stusys.domain.ClassInfo;
import com.wocnz.stusys.domain.Course;

import java.util.List;

/**
 * 查询学生选课的信息，包括学生名称，教师名称，学分，成绩等
 */
public interface ClassInfoDao {
    public List<ClassInfo> findAllClInfo();

    public List<ClassInfo> findTeasCourse();
}
