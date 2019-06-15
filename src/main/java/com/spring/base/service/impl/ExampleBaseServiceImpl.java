package com.spring.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.base.dao.impl.ExampleBaseDaoimpl;
import com.spring.base.service.BaseService;
@Service
public class ExampleBaseServiceImpl implements BaseService{
	 @Autowired
	private ExampleBaseDaoimpl exampleBaseDaoimpl;
	@Override
	public int saveOrUpdates(List list, Object user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLists(List list, Object user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveList(List list, Object user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object t, Object user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Object t, Object user) throws Exception {
			exampleBaseDaoimpl.findById(null);
		return 0;
	}

	@Override
	public List find(List list) throws Exception {
		return exampleBaseDaoimpl.find(list);
	}
}
