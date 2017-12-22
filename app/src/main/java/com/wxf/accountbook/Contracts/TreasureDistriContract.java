package com.wxf.accountbook.Contracts;

import com.wxf.accountbook.entry.PieTreasure;
import com.wxf.serviceport.entry.Treasure;

import java.util.List;

import retrofit2.Call;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureDistriContract
 * @date on 2017/12/15 17:15
 */

public class TreasureDistriContract {
    /**
     * 提示信息
     *
     */
      public  interface  TreasureDistriView{
          public  void toast(String message);
          public  void loadTreasure(List<PieTreasure> list);//记载数据
          public  void clickTreasure(String id);
      }
      public  interface  TreasureDistriPresenter{
          public  void loadTreasure();//加载数据

      }
      public  interface TreasureDistriMode{
          public Call loadTreasure();//加载数据
      }
}
