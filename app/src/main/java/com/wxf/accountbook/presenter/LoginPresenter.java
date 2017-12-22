package com.wxf.accountbook.presenter;

import android.util.Log;

import com.wxf.accountbook.Contracts.LoginContract;
import com.wxf.accountbook.entryResponse.LoginResponse;
import com.wxf.accountbook.entryResponse.LoginResponseData;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/12.
 *
 * @fileName LoginPresenter
 * @date on 2017/12/12 17:16
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {
    @Inject
    LoginContract.ILoginView loginView;
    @Inject
    LoginContract.ILoginMode loginMode;

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void login(String deviceId, String password) {
        Log.i("wxf", "login: "+deviceId);
        Log.i("wxf", "login: "+password);
        //loginView.showDialog();
        loginMode.login(deviceId,password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
          //      loginView.dissDialog();
                Log.i("wxf", "onResponse:登陆结果 "+response.body().getData().getResult());
                LoginResponseData data = response.body().getData();
                String result="未知错误";
                switch (data.getResult()){
                    case 0:
                        result="登陆成功";
                        loginView.loginSuccess("");
                        break;
                    case 1:
                        result="用户尚未注册";
                        break;
                    case 2:
                        result="密码错误";
                        break;
                    case 3:
                        result="参数为空";
                        break;
                    default:
                        result+=data.getResult();
                        break;
                }
                loginView.toast(result);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                 loginView.toast("登陆系统异常");
            }
        });

    }
}
