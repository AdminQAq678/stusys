package com.wocnz.stusys.service;

import org.springframework.stereotype.Component;

@Component
public interface commonSer {

    public boolean chgpasswd(String uid,String prePasswd, String newPasswd);

}
