package com.wocnz.stusys.domain;

/**
 * 选课信息表（sct）
 * 学号sno：char(9)
 * 课程号cno：char(6)
 * 教工号tno：char(8)
 * 成绩grade：int(4)
 */
public class Sct {

    private String sno;
    private String cno;
    private String tno;
    private String grade;

    @Override
    public String toString() {
        return "sct{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", tno='" + tno + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
