package com.wxf.accountbook.components;

import com.wxf.accountbook.activity.RegisterActivity;
import com.wxf.accountbook.modules.RegisterModule;

import dagger.Component;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName RegisterComponent
 * @date on 2017/12/13 15:53
 */

@Component(modules = RegisterModule.class)
public interface RegisterComponent {
    void inject(RegisterActivity activity);
}
