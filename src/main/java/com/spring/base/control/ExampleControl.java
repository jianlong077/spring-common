package com.spring.base.control;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.base.service.impl.ExampleBaseServiceImpl;
@RestController
public class ExampleControl<BaseJsonVo>{
	@Autowired
	private ExampleBaseServiceImpl exampleBaseServiceImpl;
	@RequestMapping("/ExampleControl/saveOrUpdates")
	public List<BaseJsonVo> saveOrUpdates(HttpServletRequest request) throws Exception {
		exampleBaseServiceImpl.save(null, null);
		return null;
	}
	@RequestMapping("/ExampleControl/find")
	public String find(HttpServletRequest request) throws Exception {
		exampleBaseServiceImpl.find(null);
		return "nihao";
	}

}
