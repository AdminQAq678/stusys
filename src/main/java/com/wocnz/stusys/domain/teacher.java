package com.wocnz.stusys.domain;

public class teacher {
    /**
     *
    教工号tno：char(8)
    姓名tname：nvarchar(8)
    性别tsex：nchar(1) （‘男’　或　‘女’）
    年龄tage：int(4)     24≤sage≤70
    学历teb：nvarchar(10)    学士、硕士、博士
    职称tpt：nvarchar(10)    助教、讲师、副教授、教授
    主讲课程一cno1: char(6)
    主讲课程二cno2: char(6)
    主讲课程三cno3: char(6)
     */
    private String tno;
    private String tname;
    private String tsex;
    private int tage;
    private String teb;
    private String tpt;
    private String tno1;
    private String tno2;
    private String tno3;

    @Override
    public String toString() {
        return "teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tage=" + tage +
                ", teb='" + teb + '\'' +
                ", tpt='" + tpt + '\'' +
                ", tno1='" + tno1 + '\'' +
                ", tno2='" + tno2 + '\'' +
                ", tno3='" + tno3 + '\'' +
                '}';
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public String getTeb() {
        return teb;
    }

    public void setTeb(String teb) {
        this.teb = teb;
    }

    public String getTpt() {
        return tpt;
    }

    public void setTpt(String tpt) {
        this.tpt = tpt;
    }

    public String getTno1() {
        return tno1;
    }

    public void setTno1(String tno1) {
        this.tno1 = tno1;
    }

    public String getTno2() {
        return tno2;
    }

    public void setTno2(String tno2) {
        this.tno2 = tno2;
    }

    public String getTno3() {
        return tno3;
    }

    public void setTno3(String tno3) {
        this.tno3 = tno3;
    }
}
