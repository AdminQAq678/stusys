package com.wocnz.stusys.dao;

import org.springframework.stereotype.Component;

import java.io.File;
@Component
public interface CommonDao {
    public boolean uploadImage(String uid, String imgurl);
    public File getHeadImage(String uid);
}
