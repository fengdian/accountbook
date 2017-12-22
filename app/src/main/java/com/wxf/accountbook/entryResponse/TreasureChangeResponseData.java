package com.wxf.accountbook.entryResponse;

import com.wxf.serviceport.entry.TreasureChange;
import com.wxf.serviceport.entry.TreasureChangeRes;

import java.util.List;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TreasureChangeResponseData
 * @date on 2017/12/19 18:29
 */

public class TreasureChangeResponseData  extends TreasureChange{
   private List<TreasureChangeRes> changeList;
    private  int result;

    public List<TreasureChangeRes> getChangeList() {
        return changeList;
    }

    public void setChangeList(List<TreasureChangeRes> changeList) {
        this.changeList = changeList;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
