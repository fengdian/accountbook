package com.wxf.serviceport.db;

/**
 * Created by 怎么着也得有个马甲 on 2017/12/7.
 *
 * @fileName TablesSql
 * @date on 2017/12/7 18:09
 */

public class TablesSql {
    //密码表
    /**
     * 包括
     * 密码
     * 手机的唯一标志
     */
    public  static  final  String PASSWORDTABLE="CREATE TABLE password (id STRING ,deviceId STRING,password STRING,createtime STRING,updatetime STRING,isdelete  INTEGER DEFAULT 0 )";
    //资产类型
    /**
     * 名称
     * 风险系数 股票为5
     * 默认
     * 股票
     * 余额宝
     * 余利宝
     * 股票基金
     * 其他
     *
     */
    public  static  final  String    TREASURETYPETABLE="CREATE TABLE treasuretype(id STRING,treasurename STRING,money INTEGER DEFAULT 0,danger INTEGER DEFAULT 0,createtime STRING,updatetime STRING,isdelete  INTEGER DEFAULT 0) ";
    //资产变化列表
    public static  final  String   TREASURECHANGETABLE="CREATE TABLE treasurechange(id STRING,treasureid STRING ,money INTEGER DEFAULT 0,type  INTEGER DEFAULT 0,createtime STRING,updatetime STRING,isdelete  INTEGER DEFAULT 0 )";
    /**
     * type
     *0:收入
     *1:支出
     *2:亏损
     * 3:盈利
     * 4：金额变化
     */
    public static  final  String   INCOMETYPE="CREATE TABLE incometype (id INTEGER DEFAULT 0,info STRING,income INTEGER,isdelete INTEGER DEFAULT 0,createtime STRING,updatetime STRING) ";




}
