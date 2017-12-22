package com.wxf.accountbook.api;

import com.wxf.accountbook.entryResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/12.
 *
 * @fileName LoginService
 * @date on 2017/12/12 15:11
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("deviceId")String deviceId,@Field("password") String password);
}
