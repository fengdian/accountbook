package com.wxf.accountbook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wxf.accountbook.Contracts.LoginContract;
import com.wxf.accountbook.Contracts.RegisterContract;
import com.wxf.accountbook.R;
import com.wxf.accountbook.Utils;
import com.wxf.accountbook.bases.BaseActivity;
import com.wxf.accountbook.components.DaggerLoginComponent;
import com.wxf.accountbook.components.DaggerRegisterComponent;
import com.wxf.accountbook.modules.LoginModule;
import com.wxf.accountbook.modules.RegisterModule;
import com.wxf.accountbook.presenter.LoginPresenter;
import com.wxf.accountbook.presenter.RegisterPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/11.
 *
 * @fileName LoginActivity
 * @date on 2017/12/11 11:53
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.IRegisterView {
    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.tv_register)
    TextView tv_register;
    @Inject
    RegisterPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerRegisterComponent.builder().registerModule(new RegisterModule(this)).build().inject(this);

    }

    @Override
    public void registerSuccess() {
        this.finish();
        backAnim();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dissDialog() {

    }

    @Override
    public void toast(String result) {
           Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.tv_register)
    public  void register(){
       presenter.register(Utils.getUserName(),et_pwd.getText().toString());

    }

    @Override
    public int getContentResourceId() {
        return R.layout.activity_register;
    }

    @Override
    public void onResponse() {

    }
}
