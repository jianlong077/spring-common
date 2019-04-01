package com.spring.dao.impl;

import java.util.List;

import com.spring.dao.base.BaseDao;
import com.spring.dao.impl.base.BaseDaoImpl;
import com.spring.entity.ExampleObjectClass;
import com.spring.entity.ExampleEntity;
/**
 * 作为实现封装接口的补充
 * @author LOVE_HAIYAN_521
 *
 */
public class ExampleDaoImpl extends BaseDaoImpl<ExampleObjectClass, ExampleEntity> implements BaseDao<ExampleObjectClass, ExampleEntity> {

	@Override
	public List<ExampleObjectClass> find(List<ExampleObjectClass> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatesToBd(List<ExampleObjectClass> list, ExampleEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int savesToBd(List<ExampleObjectClass> list, ExampleEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getKeyid(ExampleObjectClass key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createKeyid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserid(ExampleEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName(ExampleEntity user) {
		// TODO Auto-generated method stub
		return null;
	}
}
