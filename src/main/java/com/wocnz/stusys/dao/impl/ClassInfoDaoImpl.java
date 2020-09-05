package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.ClassInfoDao;
import com.wocnz.stusys.domain.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClassInfoDaoImpl implements ClassInfoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override

    public List<ClassInfo> findAllClInfo() {
        String sql="select a.sno,a.sname,b.cno,b.cname,b.cpno,b.ccredit,c.tno,c.tname,d.grade" +
                " from student  a,course b ,teacher c,sct d where a.sno=d.sno and b.cno=" +
                "d.cno and c.tno=d.tno ";
        System.out.println(jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class)));
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ClassInfo>(ClassInfo.class));
    }
}
