package com.wocnz.stusys.domain;

/**
 * 教师授课信息实体类
 */
public class TeasCourses {
    //教师编号
    private String tno;
    //课程编号
    private String cno;

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
}
