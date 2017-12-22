package com.wxf.accountbook.entryResponse;

import com.wxf.accountbook.AnnotaionData;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/12.
 *
 * @fileName LoginResponse
 * @date on 2017/12/12 16:02
 */

public class LoginResponse extends  BaseResponse {
    @AnnotaionData
    LoginResponseData data;

    public LoginResponseData getData() {
        return data;
    }

    public void setData(LoginResponseData data) {
        this.data = data;
    }
}
