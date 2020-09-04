package com.wocnz.stusys.domain;

/**
 * 院系信息表（department）
 * 系编号dno：char(3)
 * 系名dname：nvarchar(30)
 * 系主任dmanagerno： char(8)
 */
public class Department {
    private String dno;
    private String dname;
    private String dmanagerno;

    @Override
    public String toString() {
        return "department{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                ", dmanagerno='" + dmanagerno + '\'' +
                '}';
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDmanagerno() {
        return dmanagerno;
    }

    public void setDmanagerno(String dmanagerno) {
        this.dmanagerno = dmanagerno;
    }
}
