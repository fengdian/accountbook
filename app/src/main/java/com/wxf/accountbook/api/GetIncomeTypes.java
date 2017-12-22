package com.wxf.accountbook.api;

import com.wxf.accountbook.entryResponse.IncomeTypeResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/20.
 *
 * @fileName GetIncomeTypes
 * @date on 2017/12/20 12:05
 */

public interface GetIncomeTypes {

    @GET("getIncomeTypes")
    Call<IncomeTypeResponse> getIncomeTypes();
}
