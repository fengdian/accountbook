package com.wxf.accountbook;

import android.app.Application;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;
import com.wxf.serviceport.AndroidWebServer;
import com.wxf.serviceport.db.DBInstance;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName AccountBookApp
 * @date on 2017/12/8 18:22
 */

public class AccountBookApp extends Application {
    private static AccountBookApp sInstance = null;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance =this;
        CrashReport.initCrashReport(getApplicationContext(), "a11b8ebc4a", false);
        DBInstance.initDataBase(this);
        AndroidWebServer server = new AndroidWebServer(Env.IP,8889);
        try {
            server.start();
        }catch (Exception e){
            Log.i("AccountBookApp", "onCreate: "+e.toString());
        }
    }
}
