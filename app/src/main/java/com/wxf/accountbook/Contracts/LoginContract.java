package com.wxf.accountbook.Contracts;


import com.wxf.accountbook.entryResponse.LoginResponse;

import retrofit2.Call;
import rx.Observable;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/12.
 *
 * @fileName LoginContact
 * @date on 2017/12/12 14:59
 */

public class LoginContract {
    public  interface ILoginView {

        /**
         * 登录成功
         *
         * @param result
         */
        void loginSuccess(String result);
        void showDialog();
        void dissDialog();
        void toast(String result);
    }
    public  interface  ILoginPresenter{
        void login(String deviceId,String password);
    }

    public  interface ILoginMode{

        /**
         * 登录
         *
         * @param deviceId
         * @param password
         */
        Call<LoginResponse> login(String deviceId, String password);

    }
}
