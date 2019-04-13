package com.spring.base.filter.entity;

import java.io.Serializable;

import com.spring.base.entity.BaseEntity;

public class UseTimeException extends BaseEntity implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	/**
	 * 方法名
	 */
	private String method;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 耗时（秒）
	 */
	private double useTime;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public double getUseTime() {
		return useTime;
	}

	public void setUseTime(double useTime) {
		this.useTime = useTime;
	}

}
