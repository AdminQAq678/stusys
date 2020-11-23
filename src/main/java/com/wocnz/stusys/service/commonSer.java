package com.wocnz.stusys.service;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public interface commonSer {

    public boolean chgpasswd(String uid,String prePasswd, String newPasswd);
    public Object getUserInfo(String uid);
    //上传头像和获取头像
    public boolean uploadImage(String uid, String imgurl);
    public File getHeadImage(String uid);
}
