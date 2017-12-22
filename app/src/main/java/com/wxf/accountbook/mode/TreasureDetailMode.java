package com.wxf.accountbook.mode;

import com.wxf.accountbook.Contracts.TreasureItemContract;
import com.wxf.accountbook.Env;
import com.wxf.accountbook.api.AddTreasureChange;
import com.wxf.accountbook.api.GetIncomeTypes;
import com.wxf.accountbook.api.GetTreasureChangeList;
import com.wxf.accountbook.api.RegisterService;
import com.wxf.accountbook.entryResponse.AddChangeResponse;
import com.wxf.accountbook.entryResponse.RegisterResponse;
import com.wxf.accountbook.entryResponse.TreasureChangeResponse;
import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.entry.TreasureChangeRes;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TreasureDetailMode
 * @date on 2017/12/19 12:18
 */

public class TreasureDetailMode implements TreasureItemContract.ITreasureDetailMode {
    @Inject
    public TreasureDetailMode(){

    }
    @Override
    public Call loadTreasureChange(String treasureId, int  pageIndex,  int  pageSize) {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Env.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        GetTreasureChangeList service =retrofit.create(GetTreasureChangeList.class);
        Call<TreasureChangeResponse>  call =service.getTreasureChangeList(treasureId, pageIndex,pageSize);
        return call;
    }

    @Override
    public Call deleteTreasureChange(String id) {
        return null;
    }


    @Override
    public Call addTreasureChange(String treasureId, int  money, int  income,int id) {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Env.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        AddTreasureChange service =retrofit.create(AddTreasureChange.class);
        Call<AddChangeResponse>   call =service.addTreasureChange(treasureId,money,income,id+"");
        return call;
    }

    @Override
    public Call editTreeasureChange(TreasureChange change) {
        return null;
    }

    @Override
    public Call getIncomeTypes() {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Env.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        GetIncomeTypes service =retrofit.create(GetIncomeTypes.class);
        Call  call =service.getIncomeTypes();
        return call;
    }
}
