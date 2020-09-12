package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.StudentDao;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
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
    public List<Student> findAllStu() {
        String sql="select * from student";
        List<Student> students=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        System.out.println(students);

        return students;
    }

    @Override
    public  Condition<Student> findAllStuByCon(Condition con) {
        System.out.println(con);
        String sql="select * from student limit ?,? ";
        int start=(con.getCurrentPage()-1)*con.getPageSize();
        int size=con.getPageSize();
        List<Student> students=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class),start,size);
        System.out.println(students);

        String sql2="select count(*) from student";
        Integer totalCount=jdbcTemplate.queryForObject(sql2,Integer.class);

        Condition tem=new Condition();
        tem.setData(students);
        tem.setCurrentPage(con.getCurrentPage());
        //设置总数
        tem.setTotalCount(totalCount);
        return tem;
    }

    /**
     * 增加学生信息
     * @param stu
     * @return
     */
    @Override
    public boolean addStudent(Student stu) {
        System.out.println(stu);
        String sql="insert into student values(?,?,?,?,?)";
        System.out.println(sql);
        try{
            jdbcTemplate.update(sql,stu.getSno(),stu.getSname(),stu.getSsex(),stu.getSage(),stu.getSdept());
        }
        catch (Exception e){
            e.printStackTrace();
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
    public Student findStudentBySno(String sno) {
        String sql2="select *from student where sno = ?";
        Student ret=jdbcTemplate.queryForObject(sql2,new BeanPropertyRowMapper<>(Student.class),sno);
        return ret;
    }

        /**
         * 根据学号及学生信息进行更新
         * @param sno
         * @param stu
         * @return
         */
    @Override
    public Student updateStudent(String sno, Student stu) {
        System.out.println(stu+"++++++++++");
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
