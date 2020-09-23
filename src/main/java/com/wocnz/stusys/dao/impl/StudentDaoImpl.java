package com.wocnz.stusys.dao.impl;

import com.wocnz.stusys.dao.StudentDao;
import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    /**
     * jdbc模板
     * 用于执行sql语句
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger= LoggerFactory.getLogger("studao");//日志
    /**
     * 查询所有的学生信息
     * @return List<Student>
     */
    @Override
    public List<Student> findAllStu() {
        String sql="select * from student";
        List<Student> students=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        System.out.println(students);
        return students;
    }

    /**
     * 分页查询学生信息，
     * @param con
     * @return Condition<Student>
     */
    @Override
    public  Condition<Student> findAllStuByCon(Condition con) {
        System.out.println(con);
        //分页查询sql
        String sql="select * from student limit ?,? ";
        //开始的位置
        int start=(con.getCurrentPage()-1)*con.getPageSize();
        //查询的条数
        int size=con.getPageSize();
        //执行sql
        List<Student> students=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class),start,size);
        System.out.println(students);

        String sql2="select count(*) from student";
        //查询学生的数量，返回一个整型数
        Integer totalCount=jdbcTemplate.queryForObject(sql2,Integer.class);

        Condition tem=new Condition();
        //设置返回的前端的数据data
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

        logger.info(stu.toString());
        String sql="insert into student values(?,?,?,?,?,?)";
//        System.out.println(sql);
        try{

            jdbcTemplate.update(sql,stu.getSno(),stu.getSname(),stu.getSsex(),stu.getSage(),stu.getSdept(),stu.getPasswd());
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("添加学生信息sql失败"+sql+stu);
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
            //add、delete、update 三种sql 都是使用jdbcTemplate.update去执行
            jdbcTemplate.update(sql,Integer.parseInt(sno));
        }
        catch (Exception e){

            System.err.println("删除学生信息sql失败"+sql+" "+sno);
            return false;

        }
        return true;
    }

    /**
     * 通过学号查询学生信息
     * @param sno
     * @return
     */
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
//        System.out.println(stu+"++++++++++");
        String sql="update student  set sname=?, ssex=?, sage=?, sdept=?,passwd=? where sno=?  ";
        System.out.println(sql);
        int cnt=0;
        try{
            cnt=jdbcTemplate.update(sql,stu.getSname(),stu.getSsex(),stu.getSage(),stu.getSdept(),stu.getPasswd(),Integer.parseInt(sno));
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
