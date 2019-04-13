package com.spring.base.service;

import java.util.List;

public interface BaseService<T,USER> {
	/**
	 * 批量更新或添加
	 * 
	 * @param list
	 * @param user
	 * @return
	 */
	public int saveOrUpdates(List<T> list, USER user);

	/**
	 * 批量更新需要实现BD
	 * 
	 * @param list
	 * @param user
	 * @return
	 */
	public int updateLists(List<T> list, USER user);

	/**
	 * 批量添加需要实现BD
	 * 
	 * @param list
	 * @param user
	 * @return
	 */
	public int saveList(List<T> list, USER user);

	/**
	 * 单个更新
	 * 
	 * @param t
	 * @param user
	 * @return
	 */
	public int update(T t, USER user);

	/**
	 * 单个添加
	 * 
	 * @param t
	 * @param user
	 * @return
	 */
	public int save(T t, USER user);

	/**
	 * 查询需要自定义
	 * 
	 * @param list
	 * @return
	 */
	public List<T> find(List<T> list);
}
