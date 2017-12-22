package com.wxf.serviceport.entry;

import java.io.Serializable;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName Entry
 * @date on 2017/12/8 10:22
 */

public class Entry implements Serializable {
    public  String createtime;
    public  String updatetime;
    public  int isdelete;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
