package com.wxf.accountbook.modules;

import android.support.v7.app.AppCompatActivity;

import com.wxf.accountbook.Contracts.LoginContract;
import com.wxf.accountbook.activity.LoginActivity;
import com.wxf.accountbook.mode.LoginMode;
import com.wxf.accountbook.presenter.LoginPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/11.
 *
 * @fileName LoginModule
 * @date on 2017/12/11 14:24
 */

@Module
public class LoginModule {
    LoginContract.ILoginView view ;
    public LoginModule(LoginContract.ILoginView view) {
        this.view = view;
    }
   @Provides
    LoginContract.ILoginView providesLoginView(){
        return  view;
    }
    @Provides
    LoginContract.ILoginMode provideModel(LoginMode model) {
        return model;
    }
    @Provides
    String providesGame(){
        return  "王者荣耀上王者了";
    }
}
