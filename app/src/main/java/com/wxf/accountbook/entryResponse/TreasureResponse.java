package com.wxf.accountbook.entryResponse;

import com.wxf.accountbook.AnnotaionData;
import com.wxf.accountbook.entryResponse.BaseResponse;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName TreasureResponse
 * @date on 2017/12/15 18:20
 */

public class TreasureResponse extends BaseResponse {
    @AnnotaionData
    TreasureResponseData data;

    public TreasureResponseData getData() {
        return data;
    }

    public void setData(TreasureResponseData data) {
        this.data = data;
    }
}
