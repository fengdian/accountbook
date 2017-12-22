package com.wxf.accountbook.components;

import com.wxf.accountbook.activity.LoginActivity;
import com.wxf.accountbook.modules.LoginModule;

import dagger.Component;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/11.
 *
 * @fileName LoginComponent
 * @date on 2017/12/11 14:25
 */
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);

}
