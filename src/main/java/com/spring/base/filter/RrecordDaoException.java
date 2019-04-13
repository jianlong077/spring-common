package com.spring.base.filter;

/**
 * 记录持久层异常
 * 
 * @author LOVE_HAIYAN_521
 *
 */
public abstract class RrecordDaoException {
	/**
	 * 根据实际情况进行处理
	 */
	public abstract void toDealWith();
}
