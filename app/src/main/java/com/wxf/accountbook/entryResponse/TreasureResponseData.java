package com.wxf.accountbook.entryResponse;

import com.wxf.accountbook.entry.PieTreasure;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureResponseData
 * @date on 2017/12/15 18:21
 */

public class TreasureResponseData  implements Serializable{
    private int result;
    private List<PieTreasure>  treasureList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<PieTreasure> getTreasureList() {
        return treasureList;
    }

    public void setTreasureList(List<PieTreasure> treasureList) {
        this.treasureList = treasureList;
    }
}
