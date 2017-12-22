package com.wxf.accountbook.components;

import com.wxf.accountbook.activity.RegisterActivity;
import com.wxf.accountbook.activity.TreasureDistriActivity;
import com.wxf.accountbook.modules.TreasureDistriModule;

import dagger.Component;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureDistriCompont
 * @date on 2017/12/15 17:50
 */

@Component(modules = TreasureDistriModule.class)
public interface TreasureDistriCompont {
    void inject(TreasureDistriActivity activity);
}
