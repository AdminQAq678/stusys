package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.TeacherDaoImpl;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.TeacherSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherSerImpl implements TeacherSer {
    @Autowired
    TeacherDaoImpl teadDaoImpl;

    @Override
    public List<Teacher> findAllTea() {
        return teadDaoImpl.findAllTea();
    }

    @Override
    public boolean addTeacher(Teacher tea) {
        return teadDaoImpl.addTeacher(tea);
    }

    @Override
    public boolean delTeacher(String tno) {
        return teadDaoImpl.delTeacher(tno);
    }

    @Override
    public Teacher findStudentBytno(String tno) {
        return teadDaoImpl.findTeacherBytno(tno);
    }

    @Override
    public Teacher updateTeacher(String tno, Teacher tea) {
        return teadDaoImpl.updateTeacher(tno,tea);
    }
}
