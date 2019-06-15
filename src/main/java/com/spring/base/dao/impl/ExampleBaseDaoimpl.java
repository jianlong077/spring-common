package com.spring.base.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.base.entity.BaseEntity;

@Service
public class ExampleBaseDaoimpl extends BaseDaoImpl{

	@Override
	public List find(List list) throws Exception {
		 return list;
	}
	
	
	public List findById(String a) throws Exception {
		 return  new ArrayList<>();
	}

	@Override
	public int updatesToBd(List list, Object user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int savesToBd(List list, Object user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getKeyid(BaseEntity key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createKeyid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserid(Object user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName(Object user) {
		// TODO Auto-generated method stub
		return null;
	}

}
