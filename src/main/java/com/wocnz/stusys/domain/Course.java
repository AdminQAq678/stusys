package com.wocnz.stusys.domain;
/**
 * 课程信息表（course）
 * 课程号cno：char(6)
 * 课程名cname：nvarchar(50)
 * 先行课编号cpno：char(6)
 * 学分ccredit：smallint(2)
 */
public class Course {

    private String cno;
    private String cname;
    private String cpno;
    private String ccredit;

    @Override
    public String toString() {
        return "course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cpno='" + cpno + '\'' +
                ", ccredit='" + ccredit + '\'' +
                '}';
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpno() {
        return cpno;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno;
    }

    public String getCcredit() {
        return ccredit;
    }

    public void setCcredit(String ccredit) {
        this.ccredit = ccredit;
    }
}
