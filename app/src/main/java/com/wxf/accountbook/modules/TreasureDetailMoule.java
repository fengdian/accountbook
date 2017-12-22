package com.wxf.accountbook.modules;

import com.wxf.accountbook.Contracts.RegisterContract;
import com.wxf.accountbook.Contracts.TreasureItemContract;
import com.wxf.accountbook.mode.RegisterMode;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TreasureDetailMoule
 * @date on 2017/12/19 12:06
 */

@Module
public class TreasureDetailMoule {
    TreasureItemContract.ITreasureDetailView treasureDetailView;

    public TreasureDetailMoule( TreasureItemContract.ITreasureDetailView treasureDetailView) {
        this.treasureDetailView = treasureDetailView;
    }
    @Provides
    public  TreasureItemContract.ITreasureDetailView providesTreasureDetailView(){
        return treasureDetailView;
    }
    @Provides
    TreasureItemContract.ITreasureDetailMode providesTreasureDetailMode(TreasureItemContract.ITreasureDetailMode mode){
        return  mode;
    }
}
