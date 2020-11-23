package com.wocnz.stusys.domain;

import java.util.ArrayList;

/**
 * 用户角色类
 *
 */
public class Role {
    private String uid;
    private ArrayList<String> role;        //用户所拥有的角色
    private ArrayList<String> roleGroup;   //用户所处的角色组

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ArrayList<String> getRole() {
        return role;
    }

    public void setRole(ArrayList<String> role) {
        this.role = role;
    }

    public ArrayList<String> getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(ArrayList<String> roleGroup) {
        this.roleGroup = roleGroup;
    }

    @Override
    public String toString() {
        return "Role{" +
                "uid='" + uid + '\'' +
                ", role=" + role +
                ", roleGroup=" + roleGroup +
                '}';
    }
}
