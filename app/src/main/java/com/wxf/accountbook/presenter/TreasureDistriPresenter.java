package com.wxf.accountbook.presenter;

import android.util.Log;

import com.wxf.accountbook.Contracts.TreasureDistriContract;
import com.wxf.accountbook.entryResponse.TreasureResponse;
import com.wxf.accountbook.mode.TreasureDistriMode;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureDistriPresenter
 * @date on 2017/12/15 18:05
 */

public class TreasureDistriPresenter  implements TreasureDistriContract.TreasureDistriPresenter{
    @Inject
    TreasureDistriMode mode;
    @Inject
    TreasureDistriContract.TreasureDistriView view;

    @Inject
    public TreasureDistriPresenter() {
    }

    @Override
    public void loadTreasure() {
        mode.loadTreasure().enqueue(new Callback<TreasureResponse>() {
            @Override
            public void onResponse(Call<TreasureResponse> call, Response<TreasureResponse> response) {
                 view.loadTreasure(response.body().getData().getTreasureList());
            }

            @Override
            public void onFailure(Call<TreasureResponse> call, Throwable t) {
                view.toast("加载失败");

            }
        });

    }
}
