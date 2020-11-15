package com.wocnz.stusys.dao;

import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface StudentDao {
    public List<Student> findAllStu();

    public  Condition findAllStuByCon(Condition con);

    public boolean addStudent(Student stu);

    public boolean delStudent(String sno);

    public Student findStudentBySno(String sno);

    public Student updateStudent(String sno, Student stu );

    public boolean uploadImage(String uid, String imgurl);


    public File getHeadImage(String uid);

    public boolean chgpasswd(String uid,String prePasswd, String newPasswd);



}
