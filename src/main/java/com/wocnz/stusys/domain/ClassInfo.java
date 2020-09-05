package com.wocnz.stusys.domain;

import org.springframework.stereotype.Component;

/**
 * 学生选课信息
 */
@Component
public class ClassInfo {
    //学号
    private String sno;
    //学生姓名
    private String sname;
    //课程名称
    private String cno;
    //教师编号
    private String tno;
    //教师名称
    private String tname;
    //先行课程编号
    private String cpno;
    //学分
    private String ccredit;
    //课程成绩
    private String grade;

    @Override
    public String toString() {
        return "ClassInfo{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", cno='" + cno + '\'' +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", cpno='" + cpno + '\'' +
                ", ccredit='" + ccredit + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
