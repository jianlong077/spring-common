package com.spring.base.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 记录业务层执行耗费时间
 * 
 * @author LOVE_HAIYAN_521
 *
 */
public abstract class RecordServiceUseTime extends HandlerInterceptorAdapter {
	/**
	 * 根据实际情况进行处理
	 */
	public abstract void toDealWith();
}
