package com.spring.base.filter;

/**
 * 记录业务层异常
 * 
 * @author LOVE_HAIYAN_521
 *
 */
public abstract class RecordServiceException {
	/**
	 * 根据实际情况进行处理
	 */
	public abstract void toDealWith();
}
