package com.wxf.accountbook.presenter;

import android.util.Log;

import com.wxf.accountbook.Contracts.TreasureItemContract;
import com.wxf.accountbook.entryResponse.AddChangeResponse;
import com.wxf.accountbook.entryResponse.IncomeTypeResponse;
import com.wxf.accountbook.entryResponse.TreasureChangeResponse;
import com.wxf.accountbook.mode.TreasureDetailMode;
import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.entry.TreasureChangeRes;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TreasureDetailPresenter
 * @date on 2017/12/19 12:27
 */

public class TreasureDetailPresenter implements TreasureItemContract.ITreasureDetailPresenter {
    @Inject
    TreasureDetailMode mode;
    @Inject
    TreasureItemContract.ITreasureDetailView view;

    @Inject
    public TreasureDetailPresenter() {
    }

    @Override
    public void loadTreasureChange(String treasureId, int  pageIndex,  int  pageSize) {
        mode.loadTreasureChange(treasureId,pageIndex,pageSize).enqueue(new Callback<TreasureChangeResponse>() {
            @Override
            public void onResponse(Call<TreasureChangeResponse> call, Response<TreasureChangeResponse> response) {
                List<TreasureChangeRes> changeList =response.body().getData().getChangeList();
                view.loadTreasureChange(changeList);
                // view.toast("数据获取成功");
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                view.toast("数据获取失败");
            }
        });
    }

    @Override
    public void deleteTreasureChange(String id) {

    }

    @Override
    public void addTreasureChange(String treasureId, int  money, int  income,int id) {
         mode.addTreasureChange( treasureId,   money,  income,id).enqueue(new Callback<AddChangeResponse> () {
             @Override
             public void onResponse(Call<AddChangeResponse>  call, Response<AddChangeResponse>  response) {
                  int result= response.body().getData().getResult();
                   if(result==0){
                       view.addChangeSuccess("添加成功");
                   }else if(result ==1) {
                       view.toast("财富id为空");
                   }else if(result==2){
                       view.toast("财富查询失败");
                   }else if(result==3){
                       view.toast("财富不能为负值");
                   }else {
                       view.toast("未知错误："+result);
                   }
             }

             @Override
             public void onFailure(Call call, Throwable t) {
                 view.toast("异常错误："+t.toString());
             }
         });
    }

    @Override
    public void editTreeasureChange(TreasureChange change) {

    }

    @Override
    public void getIncomeTypes() {
            mode.getIncomeTypes().enqueue(new Callback<IncomeTypeResponse>() {
                @Override
                public void onResponse(Call<IncomeTypeResponse> call, Response<IncomeTypeResponse> response) {
                        int  result=  response.body().getData().getResult();
                        if(result ==0){
                            view.getIncomeTypes(response.body().getData().getIncomTypes());
                        }else {
                            view.toast("未知错误,错误密码："+result);
                        }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                        view.toast("获取失败");
                }
            });
    }
}
