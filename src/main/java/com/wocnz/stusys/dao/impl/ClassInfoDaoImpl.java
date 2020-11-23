package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.ClassInfoDao;
import com.wocnz.stusys.domain.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassInfo用于显示学生选课的课程信息、教师信息的一个实体
 * ClassInfoDaoImpl是ClassINfoDao的实现类，用于对数据库的操作
 */
@Repository
public class ClassInfoDaoImpl implements ClassInfoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    /**
     * 查询sct表的信息
     */
    public List<ClassInfo> findAllClInfo() {
        String sql="select a.sno,a.sname,b.cno,b.cname,b.cpno,b.ccredit,c.tno,c.tname,d.grade" +
                " from student  a,course b ,teacher c,sct d where a.sno=d.sno and b.cno=" +
                "d.cno and c.tno=d.tno ";
        System.out.println(jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class)));
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class));
    }

    /**
     * 查询teascourse 和course、teacher表的等值连接结果
     * 用于可选课程信息的展示
     * @return
     */
    @Override
    public List<ClassInfo> findTeasCourse() {
        String sql="select b.cno,b.cname,b.cpno,b.ccredit,c.tno,c.tname" +
                " from course b ,teacher c,teascourses d where b.cno=" +
                "d.cno and c.tno=d.tno ";
        System.out.println(jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class)));
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class));
    }

    /**
     * 根据学号查询ClassInfo
     * @param sno
     * @return
     */
    @Override
    public List<ClassInfo> findClInfosBySno(String sno) {
        //System.out.println("idid"+sno);
        String sql="select a.sno,a.sname,b.cno,b.cname,b.cpno,b.ccredit,c.tno,c.tname,d.grade" +
                " from student  a,course b ,teacher c,sct d where a.sno=d.sno and b.cno=" +
                "d.cno and c.tno=d.tno and a.sno = ? ";
        //System.out.println("查询到的课程信息"+jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class),sno));
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class),sno);
    }


}
