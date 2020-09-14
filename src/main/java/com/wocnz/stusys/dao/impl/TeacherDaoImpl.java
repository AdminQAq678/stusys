package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.TeacherDao;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Condition<Teacher> findAllTeaByCon(Condition con) {
        System.out.println(con);
        String sql="select * from teacher limit ?,? ";
        int start=(con.getCurrentPage()-1)*con.getPageSize();
        int size=con.getPageSize();
        List<Teacher> teachers=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Teacher.class),start,size);
        System.out.println(teachers);

        String sql2="select count(*) from teacher";
        Integer totalCount=jdbcTemplate.queryForObject(sql2,Integer.class);

        Condition tem=new Condition();
        tem.setData(teachers);
        tem.setCurrentPage(con.getCurrentPage());
        //设置总数
        tem.setTotalCount(totalCount);
        return tem;
    }

    @Override
    public List<Teacher> findAllTea() {
        String sql="select * from teacher";
        List<Teacher> teachers=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Teacher.class));
        System.out.println(teachers);
        return teachers;
    }

    @Override
    public boolean addTeacher(Teacher tea) {
        System.out.println(tea);
        String sql="insert into teacher values(?,?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        if(tea.getCno1().length()==0){
            tea.setCno1(null);
        }
        if(tea.getCno2().length()==0){
            tea.setCno2(null);
        }
        if(tea.getCno3().length()==0){
            tea.setCno3(null);
        }
        try{
            int cnt=jdbcTemplate.update(sql,tea.getTno(),tea.getTname(),tea.getTsex(),tea.getTage(),tea.getTeb(),tea.getTpt(),
            tea.getCno1(),tea.getCno2(),tea.getCno3());
            if(cnt>0){
                System.out.println("增加教师信息成功");
                return true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
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
    public Teacher findTeacherBytno(String tno) {
        String sql2="select *from teacher where tno = ?";
        return  jdbcTemplate.queryForObject(sql2,new BeanPropertyRowMapper<>(Teacher.class),tno);

    }

    @Override
    public Teacher updateTeacher(String tno, Teacher tea) {
        System.out.println(tno);
        String sql="update teacher  set tname=?, tsex=?, tage=?, teb=? ,tpt=?, cno1=?, cno2=?,cno3=? where tno=?  ";
        System.out.println(sql);

        try{
           int  cnt=jdbcTemplate.update(sql,tea.getTname(),tea.getTsex(),tea.getTage(),tea.getTeb(),tea.getTpt(),
                    tea.getCno1(),tea.getCno2(),tea.getCno3(),Integer.parseInt(tno));
            if (cnt>0){
                System.err.println("更新教师信息成功");
                //查询教师信息并返回后端
                return  findTeacherBytno(tno);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("更新教师sql执行失败"+sql+" "+tno);
            return null;

        }
        return null;
    }
}
