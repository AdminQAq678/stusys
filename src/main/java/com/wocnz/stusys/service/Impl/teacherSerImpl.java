package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.teacherDaoImpl;
import com.wocnz.stusys.domain.teacher;
import com.wocnz.stusys.service.teacherSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class teacherSerImpl implements teacherSer {
    @Autowired
    teacherDaoImpl teadDaoImpl;

    @Override
    public List<teacher> findAllTea() {
        return teadDaoImpl.findAllTea();
    }

    @Override
    public boolean addTeacher(teacher tea) {
        return teadDaoImpl.addTeacher(tea);
    }

    @Override
    public boolean delTeacher(String tno) {
        return teadDaoImpl.delTeacher(tno);
    }

    @Override
    public teacher findStudentBytno(String tno) {
        return teadDaoImpl.findStudentBytno(tno);
    }

    @Override
    public teacher updateTeacher(String tno, teacher tea) {
        return updateTeacher(tno,tea);
    }
}
