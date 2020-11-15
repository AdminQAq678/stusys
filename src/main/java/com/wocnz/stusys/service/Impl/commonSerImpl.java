package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.StudentDaoImpl;
import com.wocnz.stusys.dao.impl.TeacherDaoImpl;
import com.wocnz.stusys.domain.Student;
import com.wocnz.stusys.domain.Teacher;
import com.wocnz.stusys.service.commonSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class commonSerImpl implements commonSer {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentDaoImpl studentDao;

    @Autowired
    TeacherDaoImpl teacherDao;

    @Override
    public boolean chgpasswd(String uid, String prePasswd, String newPasswd) {
        String sql="update student set passwd = ? where sno = ? ";
        if(uid.indexOf("stu")!=-1){                                 //学生
            Student student=studentDao.findStudentBySno(uid);
            if(student==null){
                System.out.println("不存在该用户");
                return false;
            }
            //判断用户密码是否跟之前的相同
            if(student.getPasswd().equals(prePasswd)){

                if(jdbcTemplate.update(sql,newPasswd,uid)>0){
                    return true;
                }
            }
        }else {
            sql="update teacher set passwd = ? where tno = ? ";
            Teacher teacher=teacherDao.findTeacherBytno(uid);
            if(teacher==null){
                System.out.println("不存在该用户");
                return false;
            }
            //判断用户密码是否跟之前的相同
            if(teacher.getPasswd().equals(prePasswd)){
                if(jdbcTemplate.update(sql,newPasswd,uid)>0){
                    return true;
                }
            }

        }

        return false;
    }
}
