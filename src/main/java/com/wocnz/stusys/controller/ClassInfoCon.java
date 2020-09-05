package com.wocnz.stusys.controller;

import com.wocnz.stusys.domain.ClassInfo;
import com.wocnz.stusys.service.Impl.ClassInfoSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassInfoCon {
    @Autowired
    ClassInfoSerImpl classInfoSerImpl;
    @RequestMapping("/findAllClInfo")
    public List<ClassInfo> findAllClInfo(){
        return classInfoSerImpl.findAllClInfo();
    }
}
