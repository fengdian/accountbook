package com.wxf.accountbook.entryResponse;

import com.wxf.accountbook.AnnotaionData;

import java.io.Serializable;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName RegisterResponse
 * @date on 2017/12/13 16:29
 */

public class RegisterResponse extends BaseResponse {
    @AnnotaionData
    RegisterResponseData data;

    public RegisterResponseData getData() {
        return data;
    }

    public void setData(RegisterResponseData data) {
        this.data = data;
    }
}
