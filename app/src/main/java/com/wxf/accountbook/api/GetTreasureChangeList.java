package com.wxf.accountbook.api;

import com.wxf.accountbook.entryResponse.LoginResponse;
import com.wxf.accountbook.entryResponse.TreasureChangeResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName GetTreasureChangeList
 * @date on 2017/12/19 12:03
 */

public interface GetTreasureChangeList {
    @FormUrlEncoded
    @POST("getTreasureChangeList")
    Call<TreasureChangeResponse>  getTreasureChangeList(@Field("treasureId")String treasureId, @Field("pageIndex") int  pageIndex, @Field("pageSize") int  pageSize);
}
