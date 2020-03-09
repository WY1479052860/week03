package com.bawei.wangyi20200309.base;

import android.app.Application;
import android.content.Context;

/**
 * app辅助类
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getAppContext(){
        return context;
    }
}
