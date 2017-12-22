package com.wxf.accountbook.api;

import com.wxf.accountbook.entryResponse.AddChangeResponse;
import com.wxf.accountbook.entryResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName AddTreasureChange
 * @date on 2017/12/19 14:51
 */

public interface AddTreasureChange {
    @FormUrlEncoded
    @POST("addTreasureChange")
    Call<AddChangeResponse> addTreasureChange(@Field("treasureId")String treasureId, @Field("money") int  money, @Field("income") int  income, @Field("id")String id);
}
