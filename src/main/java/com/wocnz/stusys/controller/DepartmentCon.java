package com.wocnz.stusys.controller;


import com.wocnz.stusys.domain.Department;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.Impl.DepartmentSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DepartmentCon {
    @Autowired
    DepartmentSerImpl departmentSerImpl;

    /**
     * 获取所有学院信息
     * @param dno
     * @return
     */
    @RequestMapping("/findAllDep")
    public List<Department> findAll(@PathParam("dno") String dno){
        return  departmentSerImpl.findAllDep();

    }

    /**
     * 根据系编号dno查找学院信息
     * @param dno
     * @return
     */
    @RequestMapping(value = "/department/{dno}",method = RequestMethod.GET)
    public Department findDepartmentByDno(@PathVariable("dno") String dno){

        return departmentSerImpl.findDepartmentByDno(dno);
    }

    /**
     * 根据系编号dno更新学院信息
     * @param dno 要修改学院的系编号
     * @param department 该学院的新信息
     * @return
     */
    @RequestMapping(value = "/department/{dno}",method = RequestMethod.PUT)
    public Department updateStudent(@PathVariable("dno") String dno, Department department){

        return departmentSerImpl.updateDepartment(dno,department);
    }
    /**
     * 新增老师信息
     *
     * @param department
     * @return
     */
    @RequestMapping(value = "/department",method = RequestMethod.POST)
    public boolean addDepartment( Department department){

        return departmentSerImpl.addDepartment(department);
    }
    /**
     * 根据tno查询老师信息
     *
     * @param dno
     * @return
     */
    @RequestMapping(value = "/department/{dno}",method = RequestMethod.DELETE)
    public boolean delDepartment(@PathVariable("dno") String dno){
        return departmentSerImpl.delDepartment(dno);
    }


}
