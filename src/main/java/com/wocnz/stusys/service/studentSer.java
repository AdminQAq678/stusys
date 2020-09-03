package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.student;

import java.util.ArrayList;
import java.util.List;

public interface studentSer {
    public List<student> findAllStu();

    public boolean addStudent(student stu);

    public boolean delStudent(String sno);

    public student findStudentBySno(String sno);

    public student updateStudent(String sno, student stu );

}
