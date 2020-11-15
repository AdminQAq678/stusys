package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.ClassInfoDaoImpl;
import com.wocnz.stusys.domain.ClassInfo;
import com.wocnz.stusys.service.ClassInfoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassInfoSerImpl implements ClassInfoSer {
    @Autowired
    ClassInfoDaoImpl classInfoDaoImpl;

    @Override
    public List<ClassInfo> findAllClInfo() {
        return classInfoDaoImpl.findAllClInfo();

    }

    @Override
    public List<ClassInfo> findTeasCourse() {
        return classInfoDaoImpl.findTeasCourse();
    }

    @Override
    public List<ClassInfo> findClInfosBySno(String sno) {
        return classInfoDaoImpl.findClInfosBySno(sno);
    }

}
