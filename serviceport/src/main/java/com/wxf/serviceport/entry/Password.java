package com.wxf.serviceport.entry;



/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName Password
 * @date on 2017/12/8 10:27
 */

public class Password extends Entry {
    public String id;
    public  String password;
    public  String deviceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
