package com.wocnz.stusys.domain;

/**
 * 学生信息表（student）
 * 学号sno：char(9)
 * 姓名sname：nvarchar(8)
 * 性别ssex：nchar(1) （‘男’　或　‘女’）
 * 年龄sage：int(4)     14≤sage≤24
 * 系别sdept：nvarchar(30)
 */
public class student {
    private String sno;
    private String sname;
    private  String ssex;
    private int sage;
    private String sdept;

    @Override
    public String toString() {
        return "student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", sdept='" + sdept + '\'' +
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

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

}
