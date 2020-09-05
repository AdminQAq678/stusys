package com.wocnz.stusys.dao;


import com.wocnz.stusys.domain.Department;
import com.wocnz.stusys.domain.Sct;

import java.util.List;

public interface SctDao {
    public List<Sct> findAllSct();

    public boolean addSct(Sct sct);

    public boolean delSct(String dno);

    public Department findSct(String dno);

    public Sct updateSct(String dno, Sct sct );
}
