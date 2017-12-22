package com.wxf.accountbook.presenter;

import android.util.Log;

import com.wxf.accountbook.Contracts.RegisterContract;
import com.wxf.accountbook.entryResponse.RegisterResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName RegisterPresenter
 * @date on 2017/12/13 15:50
 */

public class RegisterPresenter implements RegisterContract.IRegisterPresenter {
    @Inject
    RegisterContract.IRegisterView registerView;
    @Inject
    RegisterContract.IRegisterMode registerMode;

    @Inject
    public RegisterPresenter() {
    }

    @Override
    public void register(String deviceId, String password) {
        registerMode.register(deviceId,password).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.i("wxf", "onResponse: 注册结果："+response.body().getData().getResult());
                String result="未知错误";
                switch (response.body().getData().getResult()){
                    case 1:
                        result="参数为空";
                        break;
                    case 2:
                        result="该账号已被注册";
                        break;
                    case 0:
                        result="注册成功";

                        break;
                    default:
                        result+=response.body().getData().getError();
                        break;
                }
                registerView.toast(result);
                if(response.body().getData().getResult() ==0){
                    registerView.registerSuccess();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                registerView.toast("系统异常:"+t.toString());

            }
        });
    }
}
