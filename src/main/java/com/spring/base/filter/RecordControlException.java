package com.spring.base.filter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 记录控制层异常
 * 
 * @author LOVE_HAIYAN_521
 *
 */
public abstract class RecordControlException extends HandlerInterceptorAdapter  {

	/**
	 * 根据实际情况进行处理
	 */
	public abstract void toDealWith();
}
