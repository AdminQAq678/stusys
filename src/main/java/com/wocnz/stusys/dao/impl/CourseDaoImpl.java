package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.CourseDao;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Course;
import com.wocnz.stusys.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 查询所有的课程信息
     * @return
     */
    @Override
    public List<Course> findAllCou() {
        String sql="select * from course";
        List<Course> courses=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Course.class));
        System.out.println(courses);
        return courses;

    }


    /**
     * 分页查询
     * @param con
     * @return
     */
    @Override
    public Condition findAllStuByCon(Condition con) {
        System.out.println(con);
        String sql="select * from course limit ?,? ";
        int start=(con.getCurrentPage()-1)*con.getPageSize();
        int size=con.getPageSize();
        List<Course> courses=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Course.class),start,size);
        System.out.println(courses);

        String sql2="select count(*) from course";
        Integer totalCount=jdbcTemplate.queryForObject(sql2,Integer.class);

        Condition tem=new Condition();
        tem.setData(courses);
        tem.setCurrentPage(con.getCurrentPage());
        //设置总数
        tem.setTotalCount(totalCount);
        return tem;
    }

    /**
     * 添加课程信息
     * @param cou
     * @return
     */
    @Override
    public boolean addCourse(Course cou) {
        if (cou.getCpno()==""){
            cou.setCpno(null);
        }
        System.out.println(cou);
        String sql="insert into course values(?,?,?,?)";
        System.out.println(sql);
        try{

            int cnt=jdbcTemplate.update(sql,cou.getCno(),cou.getCname(),cou.getCpno(),cou.getCcredit());
            if(cnt>0){
                System.err.println("增加课程信息成功"+sql+cou);
                return true;
            }
        }
        catch (Exception e){
            System.err.println("增加课程信息失败"+sql+cou);
            return false;
        }
        return false;
    }

    /**
     * 根据课程号删除课程信息
     * @param cno
     * @return
     */
    @Override
    public boolean delCourse(String cno) {
        System.out.println(cno);
        String sql="delete   from course where cno = ? ";
        System.out.println(sql);
        try{

            int cnt=jdbcTemplate.update(sql,Integer.parseInt(cno));
            if(cnt>0){
                System.err.println("删除课程信息成功"+sql+cno);
                return true;
            }
        }
        catch (Exception e){

            System.err.println("删除课程信息失败"+sql+" "+cno);
            return false;

        }
        return false;
    }

    /**
     * 根据课程号查询课程信息
     * @param cno
     * @return
     */
    @Override
    public Course findCourseByCno(String cno) {
        String sql2="select *from course where cno = ?";

        try {
            Course ret=jdbcTemplate.queryForObject(sql2,new BeanPropertyRowMapper<>(Course.class),cno);
            return ret;
        }
        catch (EmptyResultDataAccessException e){
            System.err.println("查询结果集为空");
            return null;
        }


    }

    /**
     * 根据课程号和新的课程信息更新旧的课程信息
     * @param cno
     * @param cou
     * @return
     */
    @Override
    public Course updateCourse(String cno, Course cou) {
        System.out.println(cou);
        String sql="update course  set Cname=?, Cpno=?, Ccredit=? where cno=?  ";
        System.out.println(sql);
        int cnt=0;
        try{
            cnt=jdbcTemplate.update(sql,cou.getCname(),cou.getCpno(),cou.getCcredit(),Integer.parseInt(cno));
            if (cnt>0){
                System.err.println("更新课程信息成功");
                //查询课程信息并返回后端
                return  this.findCourseByCno(cno);
            }
        }
        catch (Exception e){

            System.err.println("更新课程信息失败"+sql+" "+cno);
            return null;

        }
        return null;
    }
}
