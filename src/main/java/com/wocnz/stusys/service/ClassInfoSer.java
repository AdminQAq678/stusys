package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.ClassInfo;

import java.util.List;

/**
 *
 */
public interface ClassInfoSer {
    public List<ClassInfo> findAllClInfo();
    public List<ClassInfo> findTeasCourse();
}
