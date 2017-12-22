package com.wxf.accountbook.entryResponse;

import com.wxf.serviceport.entry.Treasure;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/15.
 *
 * @fileName Pie
 * @date on 2017/12/15 14:22
 */

public class PieTreasureRes extends Treasure {
    private float percent;//备份比
    private int color;//
    private float angle;//角度

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getColor() {
        return color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
