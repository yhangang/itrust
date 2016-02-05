package com.itrust.util;

import com.google.gson.Gson;
/**
 * json�����࣬����bean��json�ַ���֮����໥ת��
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
	 * ��beanת��Ϊjson
	 * @param o
	 * @return
	 */
	public static String toJson(Object o) {
		return gson.toJson(o);
	}

	/**
	 * ��jsonת��Ϊbean
	 * @param json
	 * @param c
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> c) {
		return gson.fromJson(json, c);
	}

}
