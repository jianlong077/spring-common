package com.spring.base.filter.entity;

import java.io.Serializable;

import com.spring.base.entity.BaseEntity;

public class UseTimeEntity extends BaseEntity implements Serializable {
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
	private String Exception;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getException() {
		return Exception;
	}
	public void setException(String exception) {
		Exception = exception;
	}
	

}
