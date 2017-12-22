package com.wxf.accountbook.entryResponse;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/20.
 *
 * @fileName AddChangeResponse
 * @date on 2017/12/20 17:34
 */

public class AddChangeResponse extends BaseResponse {
    AddChangeResponseData data;

    public AddChangeResponseData getData() {
        return data;
    }

    public void setData(AddChangeResponseData data) {
        this.data = data;
    }
}
