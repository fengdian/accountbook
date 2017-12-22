package com.wxf.accountbook.Contracts;

import com.wxf.accountbook.entryResponse.LoginResponse;
import com.wxf.accountbook.entryResponse.RegisterResponse;

import retrofit2.Call;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName RegisterContract
 * @date on 2017/12/13 15:35
 */

public class RegisterContract {
    public  interface IRegisterView{
        void registerSuccess();
        void showDialog();
        void dissDialog();
        void toast(String result);
    }
    public  interface  IRegisterPresenter{
        void register(String deviceId,String password);
    }
    public  interface IRegisterMode{


        Call<RegisterResponse> register(String deviceId, String password);

    }
}
