package com.example.lmy.ticketreservationpractice.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by jyr on 17/11/19.
 */

public class CityToCity extends BmobObject implements Serializable{
    private String trainNumber;
    private String price;
    private String city_start;
    private String city_end;

    public String getTrain_namber() {
        return trainNumber;
    }

    public void setTrain_namber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity_start() {
        return city_start;
    }

    public void setCity_start(String city_start) {
        this.city_start = city_start;
    }

    public String getCity_end() {
        return city_end;
    }

    public void setCity_end(String city_end) {
        this.city_end = city_end;
    }

    @Override
    public String toString() {
        return "CityToCity{" +
                "trainNumber='" + trainNumber + '\'' +
                ", price='" + price + '\'' +
                ", city_start='" + city_start + '\'' +
                ", city_end='" + city_end + '\'' +
                '}';
    }
}
