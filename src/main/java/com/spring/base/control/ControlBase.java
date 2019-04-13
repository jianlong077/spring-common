package com.spring.base.control;

import javax.servlet.http.HttpServletRequest;

public interface ControlBase<T,PAGE> {
	/**
	 * 批量更新或添加
	 * 
	 * @param list
	 * @param user
	 * @return
	 */
	public T saveOrUpdates(HttpServletRequest request,Object ...objects);
	/**
	 * 查询需要自定义
	 * 
	 * @param list
	 * @return
	 */
	public PAGE find(HttpServletRequest request,Object ...objects);
}
