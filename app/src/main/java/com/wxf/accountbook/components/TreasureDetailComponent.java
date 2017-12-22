package com.wxf.accountbook.components;

import com.wxf.accountbook.activity.LoginActivity;
import com.wxf.accountbook.activity.TreasureItemDetailActivity;
import com.wxf.accountbook.modules.TreasureDetailMoule;

import dagger.Component;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TreasureDetailComponent
 * @date on 2017/12/19 12:14
 */
@Component(modules = TreasureDetailMoule.class)
public interface TreasureDetailComponent {
    void inject(TreasureItemDetailActivity activity);
}
