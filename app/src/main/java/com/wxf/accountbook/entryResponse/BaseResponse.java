package com.wxf.accountbook.entryResponse;

import java.io.Serializable;

/**
 * Created by 怎么着也得有个马甲 on 2017/10/31.
 *
 * @fileName Response
 * @date on 2017/10/31 15:50
 */

public class BaseResponse implements Serializable {
    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
