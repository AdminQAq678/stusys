package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.studentDaoImpl;

import com.wocnz.stusys.domain.student;
import com.wocnz.stusys.service.studentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentSerImpl implements studentSer {
    @Autowired
    studentDaoImpl studaoImpl;

    @Override
    public List<student> findAllStu() {
        studaoImpl.findAllStu();
        return null;
    }

    @Override
    public boolean addStudent(student stu) {


        return studaoImpl.addStudent( stu);
    }

    @Override
    public boolean delStudent(String sno) {

        return studaoImpl.delStudent( sno);
    }

    @Override
    public student findStudentBySno(String sno) {

        return studaoImpl.findStudentBySno( sno);

    }

    @Override
    public student updateStudent(String sno, student stu) {

        return studaoImpl.updateStudent( sno,stu);
    }
}
