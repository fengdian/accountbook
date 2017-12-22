package com.wxf.serviceport.entry;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName TreasureChange
 * @date on 2017/12/8 10:35
 */

public class TreasureChange extends  Entry {
    public String id;
    public  String treasureid;
    public  int money;
    public  int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTreasureid() {
        return treasureid;
    }

    public void setTreasureid(String treasureid) {
        this.treasureid = treasureid;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
