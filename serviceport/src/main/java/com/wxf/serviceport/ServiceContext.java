package com.wxf.serviceport;

import com.wxf.serviceport.actions.AddTreasureChange;
import com.wxf.serviceport.actions.DeleteTreasure;
import com.wxf.serviceport.actions.DeleteTreasureChange;
import com.wxf.serviceport.actions.EditTreasure;
import com.wxf.serviceport.actions.EditTreasureChange;
import com.wxf.serviceport.actions.GetIncomeTypes;
import com.wxf.serviceport.actions.GetTreasure;
import com.wxf.serviceport.actions.GetTreasureChangeList;
import com.wxf.serviceport.actions.LoginAction;
import com.wxf.serviceport.actions.SetPassWordAction;
import com.wxf.serviceport.interfaces.INetService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/7.
 *
 * @fileName ServiceContext
 * @date on 2017/12/7 19:27
 */

public class ServiceContext {
    private static Map<String,INetService> servicesMap = null;
    static{
        servicesMap = new HashMap<>();
        servicesMap.put("/addTreasureChange",new AddTreasureChange());
        servicesMap.put("/addTreasureType",new AddTreasureChange());
        servicesMap.put("/deleteTreasure",new DeleteTreasure());
        servicesMap.put("/deleteTreasureChange",new DeleteTreasureChange());
        servicesMap.put("/editTreasure",new EditTreasure());
        servicesMap.put("/editTreasureChange",new EditTreasureChange());
        servicesMap.put("/getTreasure",new GetTreasure());
        servicesMap.put("/getTreasureChangeList",new GetTreasureChangeList());
        servicesMap.put("/login",new LoginAction());
        servicesMap.put("/setPassWord",new SetPassWordAction());
        servicesMap.put("/getIncomeTypes",new GetIncomeTypes());


    }
    public static INetService  getService(String key){
        return servicesMap.get(key);
    }
}
