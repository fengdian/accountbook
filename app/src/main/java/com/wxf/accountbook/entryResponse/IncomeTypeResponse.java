package com.wxf.accountbook.entryResponse;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/20.
 *
 * @fileName IncomeTypeResponse
 * @date on 2017/12/20 12:11
 */

public class IncomeTypeResponse extends BaseResponse {

    private IncomeTypeResponseData data;

    public IncomeTypeResponseData getData() {
        return data;
    }

    public void setData(IncomeTypeResponseData data) {
        this.data = data;
    }
}
