package com.wxf.accountbook.mode;

import com.wxf.accountbook.Contracts.LoginContract;
import com.wxf.accountbook.Env;
import com.wxf.accountbook.api.LoginService;
import com.wxf.accountbook.entryResponse.LoginResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import rx.Observable;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/12.
 *
 * @fileName LoginMode
 * @date on 2017/12/12 15:19
 */

public class LoginMode implements LoginContract.ILoginMode {
    @Inject
    public  LoginMode(){
        System.out.println("----------LoginMode---------------");
    }
    @Override
    public   Call<LoginResponse> login(String deviceId, String password) {
        Retrofit retrofit =  new Retrofit.Builder()
                             .baseUrl(Env.BASEURL)
                             .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
       LoginService service =retrofit.create(LoginService.class);
        Call<LoginResponse> call =service.login(deviceId, password);
        return call;
    }
}
