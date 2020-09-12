package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.CourseDao;
import com.wocnz.stusys.dao.SctDao;
import com.wocnz.stusys.domain.Course;
import com.wocnz.stusys.domain.Department;
import com.wocnz.stusys.domain.Sct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SctDaoImpl implements SctDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Sct> findAllSct() {
        return null;
    }

    @Override
    public boolean addSct(Sct sct) {
        return false;
    }

    @Override
    public boolean delSct(String dno) {
        return false;
    }

    @Override
    public Department findSct(String dno) {
        return null;
    }

    @Override
    public Sct updateSct(String dno, Sct sct) {
        return null;
    }
}
