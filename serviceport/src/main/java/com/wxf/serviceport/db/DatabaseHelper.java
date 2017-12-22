
package com.wxf.serviceport.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME =SDHelper.DB_DIR + File.separator +"accountbook.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        try {
        database.execSQL(TablesSql.PASSWORDTABLE);
            Log.i("wxf", "数据库建立: 成功");
       database.execSQL(TablesSql.TREASURECHANGETABLE);
        database.execSQL(TablesSql.TREASURETYPETABLE);
        database.execSQL(TablesSql.INCOMETYPE);
        }catch (Exception e){
            Log.i("wxf", "建表onCreate: "+e.toString());
            Log.i("wxf", "数据库建立: 失败："+e.toString());
        }

        Log.i("wxf", "onCreate: 我创建完了数据库");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion, int newVersion) {
    }
}
