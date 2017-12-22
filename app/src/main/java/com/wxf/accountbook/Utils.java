package com.wxf.accountbook;

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
                result="收入";
                break;
            case 1:
                result="支出";
                break;
            case 2:
                result="亏损";
                break;
            case 3:
                result="盈利";
                break;
            case 4:
                result="金额变化";
                break;
            case 5:
                result="转入";
                break;
            case 6:
                result="转出";
                break;

        }
        return  result;
    }
}
