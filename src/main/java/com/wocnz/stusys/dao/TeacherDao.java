package com.wocnz.stusys.dao;


import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Teacher;

import java.util.List;

public interface TeacherDao {

    public Condition findAllTeaByCon(Condition con);

    public List<Teacher> findAllTea();

    public boolean addTeacher(Teacher tea);

    public boolean delTeacher(String tno);

    public Teacher findTeacherBytno(String tno);

    public Teacher updateTeacher(String tno, Teacher tea );
}
