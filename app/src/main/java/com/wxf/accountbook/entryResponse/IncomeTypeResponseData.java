package com.wxf.accountbook.entryResponse;

import com.wxf.serviceport.entry.IncomeType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/20.
 *
 * @fileName IncomeTypeResponseData
 * @date on 2017/12/20 12:12
 */

public class IncomeTypeResponseData  implements Serializable {
    private int  result;
    private List<IncomeType> incomTypes;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<IncomeType> getIncomTypes() {
        return incomTypes;
    }

    public void setIncomTypes(List<IncomeType> incomTypes) {
        this.incomTypes = incomTypes;
    }
}
