package com.wxf.serviceport.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wxf.serviceport.db.DBInstance;
import com.wxf.serviceport.entry.IncomeType;
import com.wxf.serviceport.entry.Treasure;
import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.entry.TreasureChangeRes;
import com.wxf.serviceport.util.CursorUtil;
import com.wxf.serviceport.util.DateFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName TreasureDao
 * @date on 2017/12/8 11:44
 */

public class TreasureDao {

    /**
     *获取最新财富
     * @return
     */
    public  static List<Treasure>getTreasures() throws  Exception{
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String  sql ="select id" +
                ",treasurename" +
                ",money" +
                ",danger" +
                ",createtime" +
                ",updatetime" +
                ",isdelete"+
                " from treasuretype "+
                " where isdelete =0";
       Cursor cursor = db.rawQuery(sql,new String[]{});
       List<Treasure> list = CursorUtil.arrayFromCursor(cursor,Treasure.class);
       return  list;
    }
    public static  List<TreasureChange> getTreasureChanges(String id,int begin,int end)throws  Exception{
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="select id" +
                ",treasureid" +
                ",money" +
                ",type" +
                ",createtime" +
                ",updatetime "
                +" from treasurechange where isdelete =0" +
                " and treasureid=?" +
                " order by createtime DESC" +
                " limit ?,?";
        Cursor cursor = db.rawQuery(sql,new String[]{id,begin+"",end+""} );
        List<TreasureChange> list = CursorUtil.arrayFromCursor(cursor,TreasureChange.class);
        return  list;
    }
    /**
     * 添加财富类型
     * @param type
     * @return
     */
    public  static  int addTreasureType(Treasure type){
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="insert into treasuretype(id" +
                ",treasurename" +
                ",money" +
                ",danger" +
                ",createtime" +
                ",updatetime" +
                ",delete) values（?,?,?,?,?,?,？）";
        db.execSQL(sql,new String[]{
                type.getId(),
                type.getTreasurename(),
                type.getMoney()+"",
                type.getDanger()+"",
                DateFormat.simdhm.format(new Date()),
                DateFormat.simdhm.format(new Date()),
                0+""});
        return 0;
    }

    /**
     * 更新财富类型
     * @param type
     * @return
     */
    public  static  int updateTreasureType(Treasure type){
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="update treasuretype " +
                "set treasurename=?,money=?,danger=?,updatetime=? " +
                " where id=?" ;
        db.execSQL(sql,new String[]{
                type.getTreasurename(),
                type.getMoney()+""
                ,type.getDanger()+"",
                DateFormat.simdhm.format(new Date()),type.getId()});

        return  0;
    }

    /**
     * 删除财富类型
     * @param id
     * @return
     */
    public  static  int deleteTreasureType(String id){
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="update treasuretype " +
                "set delete=?" +
                " where id=?" ;
        db.execSQL(sql,new String[]{"1",id});

        return  0;
    }

    /**
     *
     */
    public  static  int addTreasureChange(TreasureChange item){
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="insert into treasurechange(id" +
                ",treasureid" +
                ",money" +
                ",type" +
                ",createtime" +
                ",updatetime" +
                ",isdelete) values(?,?,?,?,?,?,?)";
        db.execSQL(sql,new String[]{
                item.getId(),
                item.getTreasureid(),
                item.getMoney()+"",
                item.getType()+"",
                DateFormat.simdhm.format(new Date()),
                DateFormat.simdhm.format(new Date()),
                0+""});
        return 0;
    }

    /**
     * 获取资产变化类型
     * @return
     */
   public static List<IncomeType> getIncomeTypes() throws  Exception{
       SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
       String sql="select id ,info,income from incometype where isdelete = 0";
       Cursor cursor = db.rawQuery(sql,new String[]{} );
       List<IncomeType> list = CursorUtil.arrayFromCursor(cursor,IncomeType.class);
       return  list;

   }
   public  static void  updateTreasureByid(String id,int money){
       SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
       String sql="update treasuretype set money=money+"+money +" where id=?";
       db.execSQL(sql,new String[]{id});
   }
    public  static List<Treasure>  getTreasureByid(String id)throws  Exception{
        SQLiteDatabase db = DBInstance.getDatabaseHelper().getReadableDatabase();
        String sql="select id,money  from treasuretype  where id=?";
       Cursor cursor =   db.rawQuery(sql,new String[]{id});
        List<Treasure> list = CursorUtil.arrayFromCursor(cursor,Treasure.class);
        return  list;
    }

}
