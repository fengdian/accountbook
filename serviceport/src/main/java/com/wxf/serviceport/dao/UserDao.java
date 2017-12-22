package com.wxf.serviceport.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wxf.serviceport.db.DBInstance;
import com.wxf.serviceport.entry.Password;
import com.wxf.serviceport.util.CursorUtil;
import com.wxf.serviceport.util.DateFormat;
import com.wxf.serviceport.util.UUIDUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName UserDao
 * @date on 2017/12/8 10:20
 */

public class UserDao {

    /**
     * 获取登录信息
     * @param deviceId
     * @return
     * @throws Exception
     */
    public  static List<Password> getPasswordByDeviceId(String deviceId) throws Exception{
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="select id,password from password where deviceId=? and isdelete=0 ";
       Cursor cursor = db.rawQuery(sql,new String[]{deviceId});
        List<Password> list = CursorUtil.arrayFromCursor(cursor,Password.class);
        return list;
    }

    /**
     * 注册
     * @param password
     * @return
     */
    public static  int  register(Password password){
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="insert into password (id," +
                "deviceId," +
                "password," +
                "createtime," +
                "updatetime," +
                "isdelete) values(?,?,?,?,?,?)" ;
        db.execSQL(sql,new String[]{password.getId(),
                password.getDeviceId(),
                password.getPassword(),
                password.getCreatetime(),
                password.getUpdatetime(),
                password.getIsdelete()+""});
        //初始化类型DateFormat.simdhm.format(new Date())
     String d =DateFormat.simdhm.format(new Date());
        sql="insert into incometype(id,info,income,isdelete,createtime,updatetime ) values (0,'收入',1,0,?,?),(1,'支出',-1,0,?,?),(2,'亏损',-1,0,?,?),(3,'盈利',1,0,?,?),(4,'金额变化',2,0,?,?),(5,'转入',0,0,?,?),(6,'转出',0,0,?,?)";
        db.execSQL(sql,new String[]{d,d,d,d,d,d,d,d,d,d,d,d,d,d});
         sql="insert into treasuretype(id" +
                ",treasurename" +
                ",money" +
                ",danger" +
                ",createtime" +
                ",updatetime" +
                ",isdelete) values(?,?,?,?,?,?,?)";
        db.execSQL(sql,new String[]{
                UUIDUtil.getUUID(),
               "股票",
                0+"",
               5+"",
                DateFormat.simdhm.format(new Date()),
                DateFormat.simdhm.format(new Date()),
                0+""});
        db.execSQL(sql,new String[]{
                UUIDUtil.getUUID(),
                "余额宝",
                0+"",
                0+"",
                DateFormat.simdhm.format(new Date()),
                DateFormat.simdhm.format(new Date()),
                0+""});
        db.execSQL(sql,new String[]{
                UUIDUtil.getUUID(),
                "余利宝",
                0+"",
                0+"",
                DateFormat.simdhm.format(new Date()),
                DateFormat.simdhm.format(new Date()),
                0+""});
        db.execSQL(sql,new String[]{
                UUIDUtil.getUUID(),
                "股票基金",
                0+"",
                5+"",
                DateFormat.simdhm.format(new Date()),
                DateFormat.simdhm.format(new Date()),
                0+""});
        db.execSQL(sql,new String[]{
                UUIDUtil.getUUID(),
                "其他",
                0+"",
                2 +"",
                DateFormat.simdhm.format(new Date()),
                DateFormat.simdhm.format(new Date()),
                0+""});

         return  0;

    }
}
