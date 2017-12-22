package com.wxf.serviceport.actions;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.wxf.serviceport.interfaces.INetService;
import com.wxf.serviceport.service.UserService;
import com.wxf.serviceport.util.Result;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/7.
 * 登录
 * @fileName LoginAction
 * @date on 2017/12/7 19:30
 */

public class LoginAction implements INetService {
    @Override
    public String deal(NanoHTTPD.IHTTPSession session) {

        Result<Object> result = new Result<Object>();
        Map<String, String> params = session.getParms();
        String password = params.get("password");
        String deviceId = params.get("deviceId");
        Log.i("wxf", "LoginAction deal:password :"+password);
        try {
            Map<String, Object> res = UserService.login(deviceId,password);
            result.setCommon(Result.StatusEnum.SUCCESS,res);
        }catch (Exception e){
            e.printStackTrace();

            result.setCommon(Result.StatusEnum.ERROR);
        }


        return JSON.toJSONString(result);
    }
}
