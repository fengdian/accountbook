package com.wxf.serviceport.entry;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/19.
 *
 * @fileName TypeInfo
 * @date on 2017/12/19 17:10
 */

public class IncomeType extends Entry {
    private int id;
    private int income;//-1亏损 1收益 0转入转出
    private  String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
