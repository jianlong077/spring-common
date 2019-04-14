package com.spring.base.filter.entity;

import java.io.Serializable;

import com.spring.base.entity.BaseEntity;

public class BaseUseTimeEntity extends BaseEntity implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	/**
	 * 请求访问者ip
	 */
	private String ip;
	/**
	 * 方法名
	 */
	private String method;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 路径
	 */
	private double useTime;
	private Exception e;
	/**
	 * 最大内存
	 */
	private double maxMemory;
	/**
	 * 已分配内存
	 */
	private double allotMemory;
	/**
	 * 已分配内存剩余空间
	 */
	private double allotSurplusMemory;
	/**
	 * 最大可用内存
	 */
	private double canUseMaxMemory;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

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

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	public double getMaxMemory() {
		return maxMemory;
	}

	public void setMaxMemory(double maxMemory) {
		this.maxMemory = maxMemory;
	}

	public double getAllotMemory() {
		return allotMemory;
	}

	public void setAllotMemory(double allotMemory) {
		this.allotMemory = allotMemory;
	}

	
	public double getAllotSurplusMemory() {
		return allotSurplusMemory;
	}

	public void setAllotSurplusMemory(double allotSurplusMemory) {
		this.allotSurplusMemory = allotSurplusMemory;
	}

	public double getCanUseMaxMemory() {
		return canUseMaxMemory;
	}

	public void setCanUseMaxMemory(double canUseMaxMemory) {
		this.canUseMaxMemory = canUseMaxMemory;
	}

	public double getUseTime() {
		return useTime;
	}

	public void setUseTime(double useTime) {
		this.useTime = useTime;
	}
	
	public void toMaxMemoryDetail() {
		this.setMaxMemory(Runtime.getRuntime().maxMemory()/1024/1024);
		this.setAllotMemory(Runtime.getRuntime().totalMemory()/1024/1024);
		this.setAllotSurplusMemory(Runtime.getRuntime().freeMemory()/1024/1024);
		this.setCanUseMaxMemory((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory())/1024/1024);
 		
	}

}
