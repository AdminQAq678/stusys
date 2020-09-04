package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.teacherDao;
import com.wocnz.stusys.domain.teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class teacherDaoImpl implements teacherDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<teacher> findAllTea() {
        String sql="select * from student";
        List<teacher> students=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(teacher.class));
        System.out.println(students);
        return students;
    }

    @Override
    public boolean addTeacher(teacher tea) {
        System.out.println(tea);
        String sql="insert into teacher values(?,?,?,?,?)";
        System.out.println(sql);
        try{
            int cnt=jdbcTemplate.update(sql,tea.getTno(),tea.getTname(),tea.getTsex(),tea.getTage(),tea.getTeb(),tea.getTpt(),
            tea.getCno1(),tea.getCno2(),tea.getCno3());
            if(cnt>0){
                System.out.println("增加教师信息成功");
                return true;
            }

        }
        catch (Exception e){

            System.err.println("增加教师信息sql执行失败"+sql+tea);
            return false;

        }

        return false;
    }

    @Override
    public boolean delTeacher(String tno) {
        System.out.println(tno);
        String sql="delete   from teacher where tno = ? ";
        System.out.println(sql);
        try{
            int cnt=jdbcTemplate.update(sql,Integer.parseInt(tno));
            if(cnt>0){
                System.out.println("删除教师信息成功");
                return true;
            }
        }
        catch (Exception e){

            System.err.println("删除教师sql失败"+sql+" "+tno);
            return false;

        }
        return false;
    }

    @Override
    public teacher findStudentBytno(String tno) {
        String sql2="select *from teacher where sno = ?";
        return  jdbcTemplate.queryForObject(sql2,new BeanPropertyRowMapper<>(teacher.class),tno);

    }

    @Override
    public teacher updateTeacher(String tno, teacher tea) {
        System.out.println(tno);
        String sql="update teacher  set tname=?, tsex=?, tage=?, teb=? ,tpt=?, cno1=?, cno2=?,cno3=? where tno=?  ";
        System.out.println(sql);

        try{
           int  cnt=jdbcTemplate.update(sql,tea.getTname(),tea.getTsex(),tea.getTage(),tea.getTeb(),tea.getTpt(),
                    tea.getCno1(),tea.getCno2(),tea.getCno3(),Integer.parseInt(tno));
            if (cnt>0){
                System.err.println("更新教师信息成功");
                //查询教师信息并返回后端
                return  this.findStudentBytno(tno);
            }
        }
        catch (Exception e){

            System.err.println("更新教师sql执行失败"+sql+" "+tno);
            return null;

        }
        return null;
    }
}
