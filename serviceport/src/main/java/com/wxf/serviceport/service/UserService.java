package com.wxf.serviceport.service;

import android.text.TextUtils;
import android.util.Log;

import com.wxf.serviceport.dao.UserDao;
import com.wxf.serviceport.entry.Password;
import com.wxf.serviceport.util.DateFormat;
import com.wxf.serviceport.util.UUIDUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/7.
 *
 * @fileName UserService
 * @date on 2017/12/7 20:06
 */

public class UserService {
    /**
     * 登录
     * @param deviceId
     * @param password
     * @return
     */
    public static  Map<String,Object> login(String deviceId,String password)throws Exception{
        Map<String,Object> map = new HashMap<>() ;
        int result =0;
        if(TextUtils.isEmpty(deviceId)||TextUtils.isEmpty(password)){
            result =3;
            map.put("result",result);
            return  map;
        }
        List<Password> passwordList = UserDao.getPasswordByDeviceId(deviceId);
        if (passwordList==null||passwordList.size()==0){
            result =1;
            map.put("result",result);
            return  map;
        }
        Password pwd = passwordList.get(0);
        Log.i("wxf", "login:查出： "+pwd.getPassword());
        Log.i("wxf" ,"login: 输入："+password);
        if(!password.equals(pwd.getPassword())){
            result =2;
            map.put("result",result);
            return  map;
        }

        map.put("result",result);
        return  map;
    }

    /**
     * 注册
     * @param deviceId
     * @param password
     * @return
     * @throws Exception
     */
    public static Map<String,Object>register(String deviceId,String password)throws  Exception{
        Map<String,Object> map = new HashMap<>() ;
        int result =0;
        if(TextUtils.isEmpty(deviceId)||TextUtils.isEmpty(password)){
            result =1;
            map.put("result",result);
            return  map;
        }
        List<Password> passwordList = UserDao.getPasswordByDeviceId(deviceId);
        if (passwordList!=null&&passwordList.size()>0){
            result =2;
            map.put("result",result);
            return  map;
        }
        Password pwd = new Password();
        pwd.setId(UUIDUtil.getUUID());
        pwd.setDeviceId(deviceId);
        pwd.setPassword(password);
        pwd.setCreatetime(DateFormat.simdhm.format(new Date()));
        pwd.setUpdatetime(DateFormat.simdhm.format(new Date()));
        pwd.setIsdelete(0);
        UserDao.register(pwd);
        map.put("result",result);
        return  map;

    }
}
