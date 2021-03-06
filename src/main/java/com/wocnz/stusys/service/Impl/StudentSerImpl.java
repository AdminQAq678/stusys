package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.StudentDaoImpl;

import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.domain.searchInfo;
import com.wocnz.stusys.service.StudentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentSerImpl implements StudentSer {
    @Autowired
    StudentDaoImpl studaoImpl;

    @Override
    public List<Student> findAllStu() {

        return studaoImpl.findAllStu();
    }

    @Override
    public  Condition findAllStuByCon(Condition con) {
        return studaoImpl.findAllStuByCon(con);
    }

    @Override
    public boolean addStudent(Student stu) {
        return studaoImpl.addStudent( stu);
    }

    @Override
    public boolean delStudent(String sno) {

        return studaoImpl.delStudent( sno);
    }

    @Override
    public boolean delStudent(Student[] students) {
        return studaoImpl.delStudent(students);
    }

    @Override
    public Student findStudentBySno(String sno) {
        return studaoImpl.findStudentBySno( sno);
    }

    @Override
    public Student updateStudent(String sno, Student stu) {
        return studaoImpl.updateStudent( sno,stu);
    }

    @Override
    public List<Student> searchStudent(searchInfo info) {
        return studaoImpl.searchStudent(info);
    }

    @Override
    public boolean chgpasswd(String id, String passwd) {
        return studaoImpl.chgpasswd(id,passwd );
    }
}
