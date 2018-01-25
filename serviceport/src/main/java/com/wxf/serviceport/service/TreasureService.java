package com.wxf.serviceport.service;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.wxf.serviceport.dao.TreasureDao;
import com.wxf.serviceport.db.DBInstance;
import com.wxf.serviceport.entry.IncomeType;
import com.wxf.serviceport.entry.Treasure;
import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.util.DateFormat;
import com.wxf.serviceport.util.UUIDUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName TreasureDao
 * @date on 2017/12/8 15:19
 */

public class TreasureService {

    /**
     * 添加财富类型
     * @param danger
     * @param money
     * @param treasureName
     * @return
     */
    public static  Map addTreasureType(int danger,int money,String treasureName ){
        Map map =new HashMap();
        int result =0;
        if(TextUtils.isEmpty(treasureName)){
            result =1;
            map.put("result",result);
            return map;
        }
        Treasure treasure = new Treasure();
        treasure.setId(UUIDUtil.getUUID());
        treasure.setDanger(danger);
        treasure.setMoney(money);
        treasure.setTreasurename(treasureName);
        treasure.setIsdelete(0);
         TreasureDao.addTreasureType(treasure);
        map.put("result",result);
        return map;
    }

    /**
     * 添加财富变化记录
     * @param money
     * @param treasureid
     * @return
     */
    public  static  Map addTreasureChange(int money,String treasureid,int income,String id)throws  Exception{
        Map map =new HashMap();
        int result =0;
        if(TextUtils.isEmpty(treasureid)){
            result =1;
            map.put("result",result);
            return map;
        }
       List<Treasure> list =   TreasureDao.getTreasureByid(treasureid);
        if(list==null||list.size()==0){
            result =2;
            map.put("result",result);
            return map;
        }
        if(list.get(0).getMoney()+money<0){
            result =3;
            map.put("result",result);
            return map;
        }
        TreasureChange item = new TreasureChange();
        item.setId(UUIDUtil.getUUID());
        item.setMoney(money);
        item.setTreasureid(treasureid);
        item.setType(Integer.parseInt(id));
        TreasureDao.addTreasureChange(item);
        if(income<0){
            money = -money;
        }else if(income==0){
            if(Integer.parseInt(id)==6){
                money = -money;
            }
        }
        if(income ==2){
            TreasureDao.updateTreasureByid(treasureid, money);
        }else {
            TreasureDao.updateTreasureByid(treasureid, money);
        }
        map.put("result",result);
        return map;
    }

    /**
     *删除财富类型
     * @param treasureId
     * @return
     */
    public static  Map deleteTreasure(String treasureId){
        Map map =new HashMap();
        int result =0;
        if(TextUtils.isEmpty(treasureId)){
            result =1;
            map.put("result",result);
            return map;
        }
        TreasureDao.deleteTreasureType(treasureId);
        map.put("result",result);
        return map;
    }

    public static  Map updateTreasure(String treasureId,String treasureName,int money,int danger){
        Map map =new HashMap();
        int result =0;
        if(TextUtils.isEmpty(treasureId)||TextUtils.isEmpty(treasureName)){
            result =1;
            map.put("result",result);
            return map;
        }
        Treasure treasure =new Treasure();
        treasure.setId(treasureId);
        treasure.setTreasurename(treasureName);
        treasure.setMoney(money);
        treasure.setDanger(danger);
        TreasureDao.updateTreasureType(treasure);
        map.put("result",result);
        return map;
    }

    public  static  Map getTreasure()throws  Exception{
        Map map =new HashMap();
        int result =0;
        List<Treasure> treasureList = TreasureDao.getTreasures();
        map.put("result",result);
        map.put("treasureList",treasureList);
        return  map;
    }
    public  static  Map getTreasureChangeList(String treasureId,int pageIndex,int pageSize)throws Exception{
        Map map =new HashMap();
        int result =0;
        pageIndex = 0;
        pageSize =30;
       List<TreasureChange> changeList = TreasureDao.getTreasureChanges(treasureId,pageIndex,pageSize);
       map.put("result",result);
        map.put("changeList",changeList);
        return map;
    }

    /**
     *
     * @return
     */
   public static  Map getIncomeTypes()throws  Exception{
        Map map =new HashMap();
        int result =0;
        List<IncomeType> list = TreasureDao.getIncomeTypes();
        map.put("result",result);
        map.put("incomTypes",list);
        return  map;
    }
}
