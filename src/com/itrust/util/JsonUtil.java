package com.itrust.util;

import com.google.gson.Gson;
/**
 * json工具类，用于bean与json字符串之间的相互转化
 * @author yanghang
 *
 */
public class JsonUtil {
	private static Gson gson = null;
	static {
		if (gson == null) {
			gson = new Gson();
		}
	}
	/**
	 * 将bean转化为json
	 * @param o
	 * @return
	 */
	public static String toJson(Object o) {
		return gson.toJson(o);
	}

	/**
	 * 将json转化为bean
	 * @param json
	 * @param c
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> c) {
		return gson.fromJson(json, c);
	}

}
