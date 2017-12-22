package com.wxf.serviceport.entry;


/**
 * Created by 怎么着也得有个马甲 on 2017/12/8.
 *
 * @fileName Treasure
 * @date on 2017/12/8 10:29
 */

public class Treasure extends Entry {
    public  String id;
    public String treasurename;
    public  int danger;
    public  int money ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTreasurename() {
        return treasurename;
    }

    public void setTreasurename(String treasurename) {
        this.treasurename = treasurename;
    }

    public int getDanger() {
        return danger;
    }

    public void setDanger(int danger) {
        this.danger = danger;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
