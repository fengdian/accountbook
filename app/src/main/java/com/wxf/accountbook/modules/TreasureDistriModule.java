package com.wxf.accountbook.modules;

import com.wxf.accountbook.Contracts.TreasureDistriContract;
import com.wxf.accountbook.activity.TreasureDistriActivity;
import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.accountbook.mode.TreasureDistriMode;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureDistriMoule
 * @date on 2017/12/15 17:45
 */
@Module
public class TreasureDistriModule {
    TreasureDistriContract.TreasureDistriView distriView;
    public TreasureDistriModule(TreasureDistriContract.TreasureDistriView distriView){
        this.distriView =distriView;
    }
    @Provides
    public  TreasureDistriContract.TreasureDistriView providesDistriView(){
        return  distriView;
    }

    @Provides
    public TreasureDistriActivity providesActivity(){
        return  (TreasureDistriActivity)distriView;
    }
    @Provides
    public List<PieTreasure> providesList(){
        return  new ArrayList<PieTreasure>();
    }

}
