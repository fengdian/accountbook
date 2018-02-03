package com.wxf.serviceport.util;

import java.util.Date;

/**
 * 随机生成不重复的16位纯数字序列号
 * 
 */
public class SerialNumUtil {
	private static String[] ls = new String[3000];
	private static int li = 0;

	/**
	 * getPK,获得数据库使用的一个long型唯一主键，16位 
	 * 同一微秒内3000个不会重复
	 * @return
	 */
	public synchronized static String getPK() {
		String lo = getpk();
		for (int i = 0; i < 3000; i++) {
			String lt = ls[i];
			if (lt == lo) {
				lo = getPK();
				break;
			}
		}
		ls[li] = lo;
		li++;
		if (li == 3000) {
			li = 0;
		}
		return lo;
	}

	private static String getpk() {
		String a = (String.valueOf(System.currentTimeMillis())).substring(3, 13);
		String d = (String.valueOf(Math.random())).substring(2, 8);
		return a + d;
	}
	
	public synchronized static String getPayNo() {
		String a =DateFormat.simymd.format(new Date());
		String b = "8888";
		String currentTimeMillis = (String.valueOf(System.currentTimeMillis()));
		String c = currentTimeMillis.substring(currentTimeMillis.length()-12, currentTimeMillis.length());
		String d = "";
		for(int i=0;i<4;i++){
			d+=String.valueOf((int)(Math.random()*10));
		}
		return a+b+c+d;
	}
	
	

	// 测试
	public static void main(String[] args) {
		System.out.println(SerialNumUtil.getpk());
	}
}
