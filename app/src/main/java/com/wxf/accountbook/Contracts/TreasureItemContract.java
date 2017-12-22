package com.wxf.accountbook.Contracts;

import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.serviceport.entry.IncomeType;
import com.wxf.serviceport.entry.Treasure;
import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.entry.TreasureChangeRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TreasureItemContract
 * @date on 2017/12/19 10:49
 */

public class TreasureItemContract {
    public  interface ITreasureDetailView{
        public  void toast(String message);
        public  void addChangeSuccess(String message);
        public  void loadTreasureChange(List<TreasureChangeRes> list);//记载数据
        public  void getIncomeTypes(List<IncomeType> typeList);
    }
    public  interface  ITreasureDetailPresenter{
        public  void loadTreasureChange(String treasureId, int  pageIndex,  int  pageSize);//记载数据
        public  void deleteTreasureChange(String id);
        public  void addTreasureChange(String treasureId, int  money, int  income,int id);
        public  void editTreeasureChange(TreasureChange change);
        public  void getIncomeTypes();
    }
    public   interface ITreasureDetailMode{
        public  Call loadTreasureChange(String treasureId, int  pageIndex,  int  pageSize );//记载数据
        public  Call deleteTreasureChange(String id);
        public  Call addTreasureChange(String treasureId, int  money, int  income,int id);
        public Call editTreeasureChange(TreasureChange change);
        public  Call getIncomeTypes();//获取
    }

}
