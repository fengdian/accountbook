package com.wxf.accountbook.entryResponse;

import com.wxf.accountbook.AnnotaionData;
import com.wxf.serviceport.entry.TreasureRes;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TreasureChangeResponse
 * @date on 2017/12/19 18:16
 */

public class TreasureChangeResponse extends BaseResponse {
    @AnnotaionData
    TreasureChangeResponseData data;
    int result;

    public TreasureChangeResponseData getData() {
        return data;
    }

    public void setData(TreasureChangeResponseData data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
