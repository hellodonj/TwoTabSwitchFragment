package com.example.twotabswitchfragment.bean;

import java.io.Serializable;

/**
 * 描述: 批阅参数
 * 作者|时间: djj on 2019/6/20 0020 下午 3:17
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public class MarkParams implements Serializable {
    //0未批阅 1 已批阅
    private int markType;
    private String role;

    public int getMarkType() {
        return markType;
    }

    public void setMarkType(int markType) {
        this.markType = markType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
