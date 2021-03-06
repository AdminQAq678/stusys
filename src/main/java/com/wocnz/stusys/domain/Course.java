package com.wocnz.stusys.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 课程信息表（course）
 * 课程号cno：char(6)
 * 课程名cname：nvarchar(50)
 * 先行课编号cpno：char(6)
 * 学分ccredit：smallint(2)
 */
public class Course {
    @ExcelProperty("课程号")
    private String cno;
    @ExcelProperty("课程名")
    private String cname;
    @ExcelProperty("先修课程号")
    private String cpno;
    @ExcelProperty("学分")
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
