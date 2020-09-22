package com.wocnz.stusys.controller;


import com.wocnz.stusys.domain.Sct;
import com.wocnz.stusys.service.Impl.SctSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SctCon {
    @Autowired
    SctSerImpl sctSer;

    @Autowired
    Sct sct;

    /**
     * 添加学生选课信息到sct表
     */
    @RequestMapping("/addToSct")
    public boolean addToSct(@RequestBody Sct sct){

        return sctSer.addSct(sct);

    }

    @RequestMapping("/delSct")
    public boolean delSct(@RequestBody  Sct sct){
        return sctSer.delSct(sct.getSno(),sct.getCno(),sct.getTno());
    }
}
