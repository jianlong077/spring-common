package com.spring.base.control;

import javax.servlet.http.HttpServletRequest;

public interface ControlBase{
	/**
	 * 批量更新或添加
	 * @param <T>
	 * 
	 * @param list
	 * @param user
	 * @return
	 */
	public <T> T saveOrUpdates(HttpServletRequest request);
	/**
	 * 查询需要自定义
	 * @param <T>
	 * 
	 * @param list
	 * @return
	 */
	public <T> T find(HttpServletRequest request);
}
