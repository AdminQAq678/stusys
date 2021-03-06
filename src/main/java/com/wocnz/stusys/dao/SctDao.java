package com.wocnz.stusys.dao;


import com.wocnz.stusys.domain.Department;
import com.wocnz.stusys.domain.Sct;

import java.util.List;

public interface SctDao {
    public List<Sct> findAllSct();

    public boolean addSct(Sct sct);

    public boolean delSct(String sno, String cno , String tno);

    public Sct findSct(String sno, String cno , String tno);

    public Sct updateSct(String sno, String cno , String tno, Sct sct );
}
