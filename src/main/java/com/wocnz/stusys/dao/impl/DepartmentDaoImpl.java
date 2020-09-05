package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.DepartmentDao;
import com.wocnz.stusys.domain.Course;
import com.wocnz.stusys.domain.Department;
import com.wocnz.stusys.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Department> findAllDep() {
        String sql="select * from Department";
        List<Department> departments=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Department.class));
        System.out.println(departments);
        return departments;
    }



    @Override
    public boolean addDepartment(Department department) {
        System.out.println(department);
        String sql="insert into Department values(?,?,?)";
        System.out.println(sql);
        try{

            int cnt=jdbcTemplate.update(sql,department.getDno(),department.getDname(),department.getDmanagerno());
            if(cnt>0){
                System.err.println("增加院系信息成功"+sql+department);
                return true;
            }
        }
        catch (Exception e){
            System.err.println("增加院系信息失败"+sql+department);
            return false;
        }
        return false;
    }

    @Override
    public boolean delDepartment(String dno) {
        System.out.println(dno);
        String sql="delete   from Department where dno = ? ";
        System.out.println(sql);
        try{

            int cnt=jdbcTemplate.update(sql,Integer.parseInt(dno));
            if(cnt>0){
                System.err.println("删除学院信息成功"+sql+dno);
                return true;
            }
        }
        catch (Exception e){

            System.err.println("删除学院信息失败"+sql+" "+dno);
            return false;

        }
        return false;
    }

    @Override
    public Department findDepartmentByDno(String dno) {
        String sql2="select *from Department where dno = ?";

        try {
            Department ret=jdbcTemplate.queryForObject(sql2,new BeanPropertyRowMapper<>(Department.class),dno);
            return ret;
        }
        catch (EmptyResultDataAccessException e){
            System.err.println("查询结果集为空");
            return null;
        }
    }

    @Override
    public Department updateDepartment(String dno, Department department) {
        System.out.println(department);
        String sql="update Department  set  dname=?, dmanagerno=? where dno=?  ";
        System.out.println(sql);
        int cnt=0;
        try{
            cnt=jdbcTemplate.update(sql,department.getDname(),department.getDname(),Integer.parseInt(dno));
            if (cnt>0){
                System.err.println("更新学院信息成功");
                //查询课程信息并返回后端
                return  findDepartmentByDno(dno);
            }
        }
        catch (Exception e){

            System.err.println("更新学院信息失败"+sql+" "+dno);
            return null;

        }
        return null;
    }


}
