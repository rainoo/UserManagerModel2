package com.gittoy.util;

public class StringUtil {

	/*
	 * 判断一个字符型变量是否为NULL或者""字符串（包含空格的情况）。
	 * 如果是，则返回TRUE，否则，返回FALSE。
	 */
	public static boolean isNullOrEmpty(String str) {
		return str == null || "".equals(str.trim()) ? true : false;
	}
}
