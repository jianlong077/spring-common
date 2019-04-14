package com.spring.base.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleControl<BaseJsonVo> implements ControlBase{
	@RequestMapping("/ExampleControl/saveOrUpdates")
	@Override
	public List<BaseJsonVo> saveOrUpdates(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	@RequestMapping("/ExampleControl/find")
	@Override
	public String find(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "nihao ya";
	}

}
