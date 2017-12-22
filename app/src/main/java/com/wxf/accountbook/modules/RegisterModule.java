package com.wxf.accountbook.modules;

import com.wxf.accountbook.Contracts.RegisterContract;
import com.wxf.accountbook.mode.RegisterMode;
import com.wxf.accountbook.presenter.RegisterPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName RegisterModule
 * @date on 2017/12/13 15:53
 */
@Module
public class RegisterModule {
     RegisterContract.IRegisterView registerView;

    public RegisterModule(RegisterContract.IRegisterView registerView) {
        this.registerView = registerView;
    }
    @Provides
    public  RegisterContract.IRegisterView providesRegisterView(){
        return registerView;
    }
    @Provides
    RegisterContract.IRegisterMode providesRegisterMode(RegisterMode mode){
        return  mode;
    }

}
