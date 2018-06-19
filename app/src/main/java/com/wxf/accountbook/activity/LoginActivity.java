package com.wxf.accountbook.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wxf.accountbook.Contracts.LoginContract;
import com.wxf.accountbook.R;
import com.wxf.accountbook.Utils;
import com.wxf.accountbook.bases.BaseActivity;
import com.wxf.accountbook.components.DaggerLoginComponent;
import com.wxf.accountbook.modules.LoginModule;
import com.wxf.accountbook.presenter.LoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/11.
 *
 * @fileName LoginActivity
 * @date on 2017/12/11 11:53
 */

public class LoginActivity extends BaseActivity implements LoginContract.ILoginView {
    @BindView(R.id.et_pwd)
    EditText etPassword;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @Inject
    LoginPresenter presenter;


    @Override
    public void loginSuccess(String result) {
         Intent intent = new Intent(this,TreasureDistriActivity.class);
         startActivity(intent);

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dissDialog() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
    }

    @Override
    public int getContentResourceId() {
        return R.layout.activity_login;
    }

    @Override
    public void onResponse() {
    }
    @OnClick(R.id.tv_login)
    public void login(){


        presenter.login(Utils.getUserName(), etPassword.getText().toString());
    }
    @OnClick(R.id.tv_register)
    public  void register(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        intoAnim();

    }
    @Override
    public void toast(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
}
