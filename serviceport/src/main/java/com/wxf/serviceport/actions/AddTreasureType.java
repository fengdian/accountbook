package com.wxf.serviceport.actions;

import com.alibaba.fastjson.JSON;
import com.wxf.serviceport.interfaces.INetService;
import com.wxf.serviceport.service.TreasureService;
import com.wxf.serviceport.util.Result;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/7.
 *
 * @fileName AddTreasureType
 * @date on 2017/12/7 19:37
 */

public class AddTreasureType implements INetService {
    @Override
    public String deal(NanoHTTPD.IHTTPSession session) {
        Result<Object> result = new Result<Object>();
        Map<String, String> params = session.getParms();
        String money = params.get("money");
        String danger = params.get("danger");
        String treasureName= params.get("treasureName");
        try {
            Map<String, Object> res = TreasureService.addTreasureType(Integer.parseInt(danger),Integer.parseInt(money),treasureName);
            result.setCommon(Result.StatusEnum.SUCCESS,res);
        }catch (Exception e){
            e.printStackTrace();

            result.setCommon(Result.StatusEnum.ERROR);
        }


        return JSON.toJSONString(result);
    }
}
