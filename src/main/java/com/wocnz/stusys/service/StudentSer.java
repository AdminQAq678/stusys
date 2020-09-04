package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.Student;

import java.util.List;

public interface StudentSer {
    public List<Student> findAllStu();

    public boolean addStudent(Student stu);

    public boolean delStudent(String sno);

    public Student findStudentBySno(String sno);

    public Student updateStudent(String sno, Student stu );

}
