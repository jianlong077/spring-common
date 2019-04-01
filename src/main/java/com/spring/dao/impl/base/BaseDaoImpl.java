package com.spring.dao.impl.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.spring.dao.base.BaseDao;
import com.spring.entity.base.BaseEntity;

//, user
public abstract class BaseDaoImpl<T extends BaseEntity, USER> implements BaseDao<T, USER> {
	/**
	 * 多大数据量提交一次
	 */
	static int size = 1000;

	@Override
	public int saveOrUpdates(List<T> list, USER user) {
		List<T> listAdd = new ArrayList<>();
		List<T> listUpdate = new ArrayList<>();
		Integer i = 0;
		for (T t : listUpdate) {
			if (StringUtils.isEmpty(getKeyid(t))) {
				listUpdate.add(t);
			} else {
				listAdd.add(t);
			}
		}
		if (listUpdate.size() > 0) {
			i = updateLists(listUpdate, user);
		}
		if (listAdd.size() > 0) {
			i = saveList(listAdd, user);
		}
		return i;
	}

	public int updateLists(List<T> list, USER user) {
		Date today = new Date();
		int sucess = 0;
		for (T t : list) {
			t.setUpdateUserId(getUserid(user));
			t.setUpdateUserName(getUserName(user));
			t.setUpdateTime(today);
		}
		int lenth = list.size();
		int count = lenth / size;
		for (int i = 0; i < count; i++) {
			int first = i * size;
			int last = ((i + 1) * size > lenth ? lenth : (i + 1) * size);
			List<T> subList = list.subList(first, last);
			sucess = updatesToBd(subList, user);
		}
		return sucess;
	};
	public int saveList(List<T> list, USER user) {
		Date today = new Date();
		for (T t : list) {
			t.setId(createKeyid());
			t.setCreateTime(today);
		}

		int sucess = 0;
		int lenth = list.size();
		int count = lenth / size;
		for (int i = 0; i < count; i++) {
			int first = i * size;
			int last = ((i + 1) * size > lenth ? lenth : (i + 1) * size);
			List<T> subList = list.subList(first, last);
			sucess = savesToBd(subList, user);
		}
		return sucess;
	};

	@Override
	public int update(T t, USER user) {
		List<T> listUpdate = new ArrayList<>();
		listUpdate.add(t);
		return updateLists(listUpdate, user);
	}

	@Override
	public int save(T t, USER user) {
		List<T> listAdd = new ArrayList<>();
		listAdd.add(t);
		return saveList(listAdd, user);
	}
	/**
	 * 持久化到数据库更新
	 * @param list
	 * @param user
	 * @return
	 */
	public abstract int updatesToBd(List<T> list, USER user);
	/**
	 * 持久化到数据库添加
	 * @param list
	 * @param user
	 * @return
	 */
	public abstract  int savesToBd(List<T> list, USER user);
	/**
	 * 获取主键
	 * 
	 * @param key
	 * @return
	 */
	public abstract String getKeyid(T key);

	/**
	 * 生成主键
	 * 
	 * @return
	 */
	public abstract String createKeyid();

	/**
	 * 获取用户信息
	 * 
	 * @param user
	 * @return
	 */
	public abstract String getUserid(USER user);

	/**
	 * 获取用户信息
	 * 
	 * @param user
	 * @return
	 */
	public abstract String getUserName(USER user);

}
