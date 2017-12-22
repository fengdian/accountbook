package com.wxf.serviceport.actions;

import android.content.Intent;

import com.alibaba.fastjson.JSON;
import com.wxf.serviceport.dao.TreasureDao;
import com.wxf.serviceport.interfaces.INetService;
import com.wxf.serviceport.service.TreasureService;
import com.wxf.serviceport.service.UserService;
import com.wxf.serviceport.util.Result;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/7.
 * 添加财富变化信息 变化为只涉及到总金额的变化，不涉及到具体变化
 * @fileName AddTreasureChange
 * @date on 2017/12/7 19:33
 */

public class AddTreasureChange implements INetService {
    @Override
    public String deal(NanoHTTPD.IHTTPSession session) {
        Result<Object> result = new Result<Object>();
        Map<String, String> params = session.getParms();
        String money = params.get("money");
        String treasureId = params.get("treasureId");
        int income = Integer.parseInt(params.get("income"));
        String id = params.get("id");
        try {
            Map<String, Object> res = TreasureService.addTreasureChange(Integer.parseInt(money),treasureId,income,id);
            result.setCommon(Result.StatusEnum.SUCCESS,res);
        }catch (Exception e){
            e.printStackTrace();

            result.setCommon(Result.StatusEnum.ERROR);
        }


        return JSON.toJSONString(result);
    }
}
