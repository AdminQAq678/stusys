package com.wocnz.stusys.dao;


import com.wocnz.stusys.domain.teacher;

import java.util.List;

public interface teacherDao {
    public List<teacher> findAllTea();

    public boolean addTeacher(teacher tea);

    public boolean delTeacher(String tno);

    public teacher findStudentBytno(String tno);

    public teacher updateTeacher(String tno, teacher tea );
}
