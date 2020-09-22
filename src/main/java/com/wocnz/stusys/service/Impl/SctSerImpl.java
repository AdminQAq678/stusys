package com.wocnz.stusys.service.Impl;

import com.wocnz.stusys.dao.impl.SctDaoImpl;
import com.wocnz.stusys.domain.Sct;
import com.wocnz.stusys.service.SctSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SctSerImpl implements SctSer {

    @Autowired
    SctDaoImpl sctDaoImpl;
    @Override
    public List<Sct> findAllSct() {
        return sctDaoImpl.findAllSct();
    }

    @Override
    public boolean addSct(Sct sct) {
        return sctDaoImpl.addSct(sct);
    }

    @Override
    public boolean delSct(String sno, String cno, String tno) {
        return sctDaoImpl.delSct(sno,cno,tno);
    }

    @Override
    public Sct findSct(String sno, String cno, String tno) {
        return sctDaoImpl.findSct(sno,cno,tno);
    }

    @Override
    public Sct updateSct(String sno, String cno, String tno, Sct sct) {
        return sctDaoImpl.updateSct(sno,cno,tno,sct);
    }


}
