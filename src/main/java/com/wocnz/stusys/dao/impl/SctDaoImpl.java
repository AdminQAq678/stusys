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

/**
 * sct表的增删查改
 * 学生选课信息数据库操作
 */
@Repository
public class SctDaoImpl implements SctDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Sct> findAllSct() {
        return null;
    }

    /**
     *添加sct
     * @param sct
     * @return
     */
    @Override
    public boolean addSct(Sct sct) {



        String sql="insert into sct values(?,?,?,?)";
        if(sct.getGrade().length()==0){
            sct.setGrade(null);
        }

        try{
            jdbcTemplate.update(sql,sct.getSno(),sct.getCno(),sct.getTno(),sct.getGrade());
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("插入sql失败"+sql+sct);
            return false;
        }
        return true;
    }

    @Override
    public boolean delSct(String sno, String cno, String tno) {
        System.out.println(sno);
        String sql="delete   from sct where sno = ? and cno=? and tno=?";
        System.out.println(sql);
        try{
            jdbcTemplate.update(sql,sno,cno,tno);
        }
        catch (Exception e){

            System.err.println("删除sql执行失败"+sql+" "+sno);
            return false;

        }
        return true;


    }

    /**
     * 查询选课信息接口
     * @param sno
     * @param cno
     * @param tno
     * @return
     */
    @Override
    public Sct findSct(String sno, String cno, String tno) {

        return null;
    }

    /**
     *
     * @param sno
     * @param cno
     * @param tno
     * @param sct
     * @return
     */
    @Override
    public Sct updateSct(String sno, String cno, String tno, Sct sct) {

        String sql="update sct  set sno=?, cno=?, tno=?, grade=? where sno=? and cno=? and tno=? ";
        System.out.println(sql);
        int cnt=0;
        try{
            cnt=jdbcTemplate.update(sql,sct.getSno(),sct.getCno(),sct.getTno(),sct.getGrade(),sno,cno,tno);
            if (cnt>0){
                System.err.println("更新sct选课信息成功");
                //查询学生信息并返回后端
                return  this.findSct(sct.getSno(),sct.getCno(),sct.getTno());
            }
        }
        catch (Exception e){

            System.err.println("更新sct选课信息失败"+sql+" "+sct);
            return null;

        }
        return null;
    }

}
