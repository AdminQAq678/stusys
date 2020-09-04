package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.Teacher;

import java.util.List;

public interface TeacherSer {
    public List<Teacher> findAllTea();

    public boolean addTeacher(Teacher tea);

    public boolean delTeacher(String tno);

    public Teacher findStudentBytno(String tno);

    public Teacher updateTeacher(String tno, Teacher tea );

}
