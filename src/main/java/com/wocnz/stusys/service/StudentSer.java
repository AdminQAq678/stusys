package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.domain.searchInfo;

import java.util.ArrayList;
import java.util.List;

public interface StudentSer {
    public List<Student> findAllStu();

    public  Condition findAllStuByCon(Condition con);

    public boolean addStudent(Student stu);

    public boolean delStudent(String sno);

    public boolean delStudent(Student[] students);

    public Student findStudentBySno(String sno);

    public Student updateStudent(String sno, Student stu );

    public List<Student> searchStudent(searchInfo info);

    public boolean chgpasswd(String id, String passwd);
}
