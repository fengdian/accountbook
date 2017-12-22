package com.wxf.accountbook.entryResponse;

import com.wxf.serviceport.entry.IncomeType;

import java.util.List;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TypeInfoResponseData
 * @date on 2017/12/19 19:36
 */

public class TypeInfoResponseData {
    List<IncomeType> list;

    public List<IncomeType> getList() {
        return list;
    }

    public void setList(List<IncomeType> list) {
        this.list = list;
    }
}
