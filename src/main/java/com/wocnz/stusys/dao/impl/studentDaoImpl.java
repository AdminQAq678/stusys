package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.studentDao;
import com.wocnz.stusys.domain.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class studentDaoImpl implements studentDao {
    /**
     * jdbc模板
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     *
     * @return
     */
    @Override
    public List<student> findAllStu() {
        String sql="select * from student";
        List<student> students=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(student.class));
        System.out.println(students);

        return students;
    }

    /**
     * 增加学生信息
     * @param stu
     * @return
     */
    @Override
    public boolean addStudent(student stu) {
        System.out.println(stu);
        String sql="insert into student values(?,?,?,?,?)";
        System.out.println(sql);
        try{
            jdbcTemplate.update(sql,stu.getSno(),stu.getSname(),stu.getSsex(),stu.getSage(),stu.getSdept());
        }
        catch (Exception e){

            System.err.println("插入sql失败"+sql+stu);
            return false;

        }

        return true;
    }

    /**
     * 根据学号删除学生信息
     * @param sno
     * @return
     */
    @Override
    public boolean delStudent(String sno) {
        System.out.println(sno);
        String sql="delete   from student where sno = ? ";
        System.out.println(sql);
        try{
            jdbcTemplate.update(sql,Integer.parseInt(sno));
        }
        catch (Exception e){

            System.err.println("插入sql失败"+sql+" "+sno);
            return false;

        }
        return true;
    }

    @Override
    public student findStudentBySno(String sno) {
        String sql2="select *from student where sno = ?";
        student ret=jdbcTemplate.queryForObject(sql2,new BeanPropertyRowMapper<>(student.class),sno);
        return ret;
    }

        /**
         * 根据学号及学生信息进行更新
         * @param sno
         * @param stu
         * @return
         */
    @Override
    public student updateStudent(String sno, student stu) {
        System.out.println(sno);
        String sql="update student  set sname=?, ssex=?, sage=?, sdept=? where sno=?  ";
        System.out.println(sql);
        int cnt=0;
        try{
            cnt=jdbcTemplate.update(sql,stu.getSname(),stu.getSsex(),stu.getSage(),stu.getSdept(),Integer.parseInt(sno));
            if (cnt>0){
                System.err.println("更新学生信息成功");
                //查询学生信息并返回后端
                return  this.findStudentBySno(sno);
            }
        }
        catch (Exception e){

            System.err.println("插入sql失败"+sql+" "+sno);
            return null;

        }
        return null;
    }


}
