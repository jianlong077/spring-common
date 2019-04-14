package com.spring.base.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 记录持久层异常
 * 
 * @author LOVE_HAIYAN_521
 *
 */
public abstract class RrecordDaoException extends HandlerInterceptorAdapter {
	/**
	 * 根据实际情况进行处理
	 */
	public abstract void toDealWith();
}
