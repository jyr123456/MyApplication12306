package com.example.lmy.ticketreservationpractice.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by jyr on 17/11/19.
 */

public class City extends BmobObject {
    private String cityname;

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
