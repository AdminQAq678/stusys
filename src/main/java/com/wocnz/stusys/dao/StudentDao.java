package com.wocnz.stusys.dao;

import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> findAllStu();

    public  Condition findAllStuByCon(Condition con);

    public boolean addStudent(Student stu);

    public boolean delStudent(String sno);

    public Student findStudentBySno(String sno);

    public Student updateStudent(String sno, Student stu );
}
