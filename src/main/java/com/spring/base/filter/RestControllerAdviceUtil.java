package com.spring.base.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import com.spring.base.common.date.DateUtil;
import com.spring.base.common.exception.ExceptionUtil;
import com.spring.base.common.http.HttpUtil;
import com.spring.base.filter.entity.BaseUseTimeEntity;

//@RestControllerAdvice
public abstract class RestControllerAdviceUtil{
	//@ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest request, Exception ex) throws Exception {
		String str = "";
		if (null != ex) {
			str = ExceptionUtil.getExceptionAllinformation_01(ex);
		}
		if (str != "") {
			BaseUseTimeEntity baseUseTime = new BaseUseTimeEntity();
			baseUseTime.setIp(HttpUtil.getIPAddress(request));
			baseUseTime.setMethod(request.getRequestURI());
			baseUseTime.toMaxMemoryDetail();
			// 得到线程绑定的局部变量（开始时间）
			baseUseTime.setException(str);
			toDealWith(baseUseTime);
		}
    }
	
	/**
	 * 根据实际情况进行处理
	 */
	public abstract void toDealWith(BaseUseTimeEntity baseUseTime);
}
