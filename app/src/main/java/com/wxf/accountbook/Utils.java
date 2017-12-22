package com.wxf.accountbook;

import android.text.Html;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/20.
 *
 * @fileName Utils
 * @date on 2017/12/20 16:11
 */

public class Utils {
    public static String getIncomeInfo(int type){
        String result="";
        switch (type){
            case 0:
                 //红色
                result ="<font color='#FF0000' > \t收入\t </font>";
                break;
            case 1:
                //绿色
                result="<font color='#00A600' >\t支出\t</font>";

                break;
            case 2:

                result="<font color='#00A600' >\t亏损\t</font>";
                break;
            case 3:
                result ="<font color='#FF0000' >\t盈利\t</font>";
                break;
            case 4:
                result="金额变化";
                result ="<font color='#436EEE' >\t金额变化\t</font>";
                break;
            case 5:
                result ="<font color='#FF0000' >\t转入\t</font>";
                break;
            case 6:
                result="<font color='#00A600' >\t转出\t</font>";
                break;

        }
        return result;
    }
}
