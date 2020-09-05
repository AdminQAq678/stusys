package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.DepartmentDaoImpl;
import com.wocnz.stusys.domain.Department;
import com.wocnz.stusys.service.DepartmentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentSerImpl implements DepartmentSer {
    @Autowired
    DepartmentDaoImpl departmentDao;

    @Override
    public List<Department> findAllDep() {
        return departmentDao.findAllDep();
    }

    @Override
    public boolean addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public boolean delDepartment(String dno) {
        return departmentDao.delDepartment(dno);
    }

    @Override
    public Department findDepartmentByDno(String dno) {
        return departmentDao.findDepartmentByDno(dno);
    }

    @Override
    public Department updateDepartment(String dno, Department department) {
        return departmentDao.updateDepartment(dno, department);
    }
}
