package com.wxf.serviceport.util;

import java.util.UUID;

/**
 * 生成UUID的工具类
 * @date 2017年7月3日 下午8:29:02
 */
public class UUIDUtil {

	/**
	 * 获取去掉“-”的UUID
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		// 去掉"-"符号
		return uuid.replace("-", "");
	}

	/**
	 * 获取一个指定书目的UUID
	 * @return
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] uuid = new String[number];
		for (int i = 0; i < number; i++) {
			if (i % 2 == 0) {
				uuid[i] = getUUID();
			} else {
				uuid[i] = getUUID();
			}
		}
		return uuid;
	}

	public static void main(String[] args) {
		String ss = getUUID();
//		for (int i = 0; i < ss.length; i++) {
//			System.out.println(ss[i]);
//		}
		System.out.println(ss);
	}

}
