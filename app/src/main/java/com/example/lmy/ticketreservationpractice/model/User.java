package com.example.lmy.ticketreservationpractice.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by jyr on 17/11/19.
 */

public class User extends BmobUser {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
