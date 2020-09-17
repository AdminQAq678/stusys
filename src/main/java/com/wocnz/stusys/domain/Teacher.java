package com.wocnz.stusys.domain;

public class Teacher {
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
    private String cno1;
    private String cno2;
    private String cno3;

    private String passwd;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    @Override
    public String toString() {
        return "teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tage=" + tage +
                ", teb='" + teb + '\'' +
                ", tpt='" + tpt + '\'' +
                ", cno1='" + cno1 + '\'' +
                ", cno2='" + cno2 + '\'' +
                ", cno3='" + cno3 + '\'' +
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

    public String getCno1() {
        return cno1;
    }

    public void setCno1(String cno1) {
        this.cno1 = cno1;
    }

    public String getCno2() {
        return cno2;
    }

    public void setCno2(String cno2) {
        this.cno2 = cno2;
    }

    public String getCno3() {
        return cno3;
    }

    public void setCno3(String cno3) {
        this.cno3 = cno3;
    }




}
