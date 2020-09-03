package com.wocnz.stusys.dao;

import com.wocnz.stusys.domain.student;

import java.util.ArrayList;
import java.util.List;

public interface studentDao {
    public List<student> findAllStu();

    public boolean addStudent(student stu);

    public boolean delStudent(String sno);

    public student findStudentBySno(String sno);

    public student updateStudent(String sno, student stu );
}
