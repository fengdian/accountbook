package com.wxf.serviceport.actions;

import com.alibaba.fastjson.JSON;
import com.wxf.serviceport.interfaces.INetService;
import com.wxf.serviceport.service.UserService;
import com.wxf.serviceport.util.Result;

import java.util.HashMap;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/7.
 * 设置密码
 * @fileName SetPassWordAction
 * @date on 2017/12/7 19:26
 */

public class SetPassWordAction implements INetService {
    @Override
    public String deal(NanoHTTPD.IHTTPSession session) {
        Result<Object> result = new Result<Object>();
        Map<String, String> params = session.getParms();
        String password = params.get("password");
        String deviceId = params.get("deviceId");
        try {
            Map<String, Object> res = UserService.register(deviceId,password);
            result.setCommon(Result.StatusEnum.SUCCESS,res);
        }catch (Exception e){
            e.printStackTrace();
            result.setCommon(Result.StatusEnum.ERROR);
        }


        return JSON.toJSONString(result);
    }
}
