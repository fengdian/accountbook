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
 * @fileName GetTreasureChangeList
 * @date on 2017/12/7 19:47
 */

public class GetTreasureChangeList implements INetService {
    @Override
    public String deal(NanoHTTPD.IHTTPSession session) {
        Result<Object> result = new Result<Object>();
        Map<String, String> params = session.getParms();
        String treasureId = params.get("treasureId");
        String pageIndex =params.get("pageIndex");
        String pageSize = params.get("pageSize");
        try {
            Map<String, Object> res = TreasureService.getTreasureChangeList(treasureId, Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
            result.setCommon(Result.StatusEnum.SUCCESS,res);
        }catch (Exception e){
            e.printStackTrace();

            result.setCommon(Result.StatusEnum.ERROR);
        }


        return JSON.toJSONString(result);
    }
}
