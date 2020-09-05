package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.Department;

import java.util.List;

public interface DepartmentSer {
    public List<Department> findAllDep();

    public boolean addDepartment(Department department);

    public boolean delDepartment(String dno);

    public Department findDepartmentByDno(String dno);

    public Department updateDepartment(String dno, Department department );
}
