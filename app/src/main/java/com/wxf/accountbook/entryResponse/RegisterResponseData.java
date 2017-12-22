package com.wxf.accountbook.entryResponse;

import java.io.Serializable;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/13.
 *
 * @fileName LoginResponseData
 * @date on 2017/12/13 14:32
 */

public class RegisterResponseData implements Serializable {
    private int  result;
    private String error;
    public int getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
