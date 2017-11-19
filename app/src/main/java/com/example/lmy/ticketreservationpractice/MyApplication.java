package com.example.lmy.ticketreservationpractice;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * 整个安卓app的对象
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /**
     * 全局初始化操作
     */
    private void init() {
        Bmob.initialize(this, "5d059459318484484948d98ef10776b0");

    }
}
