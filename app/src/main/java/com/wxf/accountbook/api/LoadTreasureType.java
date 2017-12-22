package com.wxf.accountbook.api;

import com.wxf.accountbook.entryResponse.LoginResponse;
import com.wxf.accountbook.entryResponse.TreasureResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName LoadTreasureType
 * @date on 2017/12/15 18:31
 */

public interface LoadTreasureType {
    @GET("getTreasure")
    Call<TreasureResponse> loadtreasure();
}
