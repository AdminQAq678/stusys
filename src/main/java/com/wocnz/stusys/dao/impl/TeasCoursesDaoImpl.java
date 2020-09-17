package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.TeasCoursesDao;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.TeasCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TeasCoursesDaoImpl implements TeasCoursesDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<TeasCourses> findAll() {
        String sql="select *from teascourses ";

        return    jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TeasCourses.class));
    }

    @Override
    public Condition findAllByCon(Condition con) {
        System.out.println(con);
        String sql="select * from teascourses limit ?,? ";
        int start=(con.getCurrentPage()-1)*con.getPageSize();
        int size=con.getPageSize();
        List<TeasCourses> teasCourses=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TeasCourses.class),start,size);
        System.out.println(teasCourses);

        String sql2="select count(*) from teascourses";
        Integer totalCount=jdbcTemplate.queryForObject(sql2,Integer.class);

        Condition tem=new Condition();
        tem.setData(teasCourses);
        tem.setCurrentPage(con.getCurrentPage());
        //设置总数
        tem.setTotalCount(totalCount);
        return tem;
    }

    @Override
    public boolean add(TeasCourses cou) {
        System.out.println(cou);
        String sql="insert into teascourses values(?,?)";
        System.out.println(sql);

        try{
            int cnt=jdbcTemplate.update(sql,cou.getTno(),cou.getCno());
            if(cnt>0){
                System.out.println("增加授课信息成功");
                return true;
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("增加授课信息sql执行失败"+sql+cou);
            return false;

        }

        return false;
    }

    @Override
    public boolean del(String cno) {

        String sql="delete   from teascourses where  cno=? ";
        System.out.println(sql);
        try{
            int cnt=jdbcTemplate.update(sql,cno);
            if(cnt>0){
                System.out.println("删除授课信息成功");
                return true;
            }
        }
        catch (Exception e){

            System.err.println("删除教师sql失败"+sql+" ");
            return false;

        }
        return false;
    }

    @Override
    public TeasCourses findByCno(String cno) {
        String sql2="select *from teasCourses where cno = ?";
        TeasCourses tem;
        try {
             tem=jdbcTemplate.queryForObject(sql2,new BeanPropertyRowMapper<>(TeasCourses.class),cno);
             return tem;
        }
        catch (Exception e){

            return null;
        }


    }

    @Override
    public TeasCourses update(String cno, TeasCourses tcs) {
        System.out.println(cno);
        String sql="update teasCourses  set tno=? ,cno=? where  cno=?  ";
        System.out.println(sql+"++++++++++++++"+tcs.getCno()+"============"+tcs.getTno());

        try{
            int  cnt=jdbcTemplate.update(sql,tcs.getTno(),tcs.getCno(),cno);
            if (cnt>0){
                System.err.println("更新教师信息成功");
                //查询教师信息并返回后端
                return findByCno(tcs.getCno());
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("更新查询授课信息sql执行失败"+sql+" ");
            return null;

        }
        return null;
    }
}
