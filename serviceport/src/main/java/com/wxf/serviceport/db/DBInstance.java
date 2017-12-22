package com.wxf.serviceport.db;

import android.app.Application;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName DBInstance
 * @date on 2017/12/8 10:47
 */

public class DBInstance {
    private static  DatabaseHelper databaseHelper;
    public static  void initDataBase(Application application){
         databaseHelper = new DatabaseHelper(application);
        Log.i("wxf", "数据库建立: ");
    }
    public static DatabaseHelper  getDatabaseHelper(){
        return  databaseHelper;

    }
}
