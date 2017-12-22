package com.wxf.accountbook.api;

import com.wxf.accountbook.entryResponse.LoginResponse;
import com.wxf.accountbook.entryResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName RegisterService
 * @date on 2017/12/13 17:08
 */

public interface RegisterService {
    @FormUrlEncoded
    @POST("setPassWord")
    Call<RegisterResponse> register(@Field("deviceId")String deviceId, @Field("password") String password);
}
