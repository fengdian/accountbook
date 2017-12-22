package com.wxf.accountbook.mode;

import com.wxf.accountbook.Contracts.TreasureDistriContract;
import com.wxf.accountbook.Env;
import com.wxf.accountbook.api.LoadTreasureType;
import com.wxf.accountbook.api.RegisterService;
import com.wxf.accountbook.entryResponse.RegisterResponse;
import com.wxf.accountbook.entryResponse.TreasureResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureDistiMode
 * @date on 2017/12/15 18:25
 */

public class TreasureDistriMode implements TreasureDistriContract.TreasureDistriMode {
   @Inject
    public TreasureDistriMode() {
    }

    @Override
    public Call<TreasureResponse> loadTreasure() {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Env.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        LoadTreasureType service =retrofit.create(LoadTreasureType.class);
        Call<TreasureResponse> call =service.loadtreasure();
        return call;
    }
}
