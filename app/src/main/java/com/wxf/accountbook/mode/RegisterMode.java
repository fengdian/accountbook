package com.wxf.accountbook.mode;

import com.wxf.accountbook.Contracts.RegisterContract;
import com.wxf.accountbook.Env;
import com.wxf.accountbook.api.LoginService;
import com.wxf.accountbook.api.RegisterService;
import com.wxf.accountbook.entryResponse.LoginResponse;
import com.wxf.accountbook.entryResponse.RegisterResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName RegisterMode
 * @date on 2017/12/13 15:51
 */

public class RegisterMode implements RegisterContract.IRegisterMode {
    @Inject
    public RegisterMode() {
    }

    @Override
    public Call<RegisterResponse> register(String deviceId, String password) {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Env.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        RegisterService service =retrofit.create(RegisterService.class);
        Call<RegisterResponse> call =service.register(deviceId, password);
        return call;
    }
}
