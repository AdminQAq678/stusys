package com.wocnz.stusys.service;

import com.wocnz.stusys.domain.Sct;

import java.util.List;

public interface SctSer {
    public List<Sct> findAllSct();

    public boolean addSct(Sct sct);

    public boolean delSct(String sno, String cno , String tno);

    public Sct findSct(String sno, String cno , String tno);

    public Sct updateSct(String sno, String cno , String tno, Sct sct );
}
