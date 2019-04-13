package com.spring.base.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonUtil {
	/**
	 * 由json串获取实体类
	 * @param <T>
	 * @param json
	 * @return
	 */
	public static <T> T getBeean(String json) {
		T clazz = JSON.parseObject(json, new TypeReference<T>() {
		});
		return clazz;
	}
	/**
	 * 由实体类生成json串
	 * @param object
	 * @return
	 */
	public static String toJsonString(Object object) {
		return JSON.toJSONString(object);
	}
}
