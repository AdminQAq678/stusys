package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.Condition;
import com.wocnz.stusys.domain.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface StudentSer {
    public List<Student> findAllStu();

    public  Condition findAllStuByCon(Condition con);

    public boolean addStudent(Student stu);

    public boolean delStudent(String sno);

    public Student findStudentBySno(String sno);

    public Student updateStudent(String sno, Student stu );

    public boolean uploadImage(String uid, String imgurl);

    public boolean chgpasswd(String uid,String prePasswd, String newPasswd);

    public File getHeadImage(String uid);
}
