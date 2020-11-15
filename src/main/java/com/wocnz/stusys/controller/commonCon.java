package com.wocnz.stusys.controller;

import com.wocnz.stusys.service.Impl.commonSerImpl;
import com.wocnz.stusys.service.StudentSer;
import com.wocnz.stusys.service.TeacherSer;
import com.wocnz.stusys.service.commonSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class commonCon {
    @Autowired
    commonSerImpl common;


    @PostMapping("/stu/chgpasswd")
    public boolean chgPasswd(String uid,String prePasswd, String newPasswd){
        return  common.chgpasswd(uid, prePasswd, newPasswd);

    }

}
