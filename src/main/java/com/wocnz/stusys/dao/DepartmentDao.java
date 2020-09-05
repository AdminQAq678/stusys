package com.wocnz.stusys.dao;


import com.wocnz.stusys.domain.Department;
import com.wocnz.stusys.domain.Teacher;

import java.util.List;

public interface DepartmentDao {
    public List<Department> findAllDep();

    public boolean addDepartment(Department department);

    public boolean delDepartment(String dno);

    public Department findDepartmentByDno(String dno);

    public Department updateDepartment(String dno, Department department );
}
