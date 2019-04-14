package com.spring.base.filter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.base.common.date.DateUtil;
import com.spring.base.common.exception.ExceptionUtil;
import com.spring.base.common.http.HttpUtil;
import com.spring.base.common.json.JsonUtil;
import com.spring.base.filter.entity.BaseUseTimeEntity;

/**
 * 记录控制层执行耗费时间
 * 
 * @author LOVE_HAIYAN_521
 *
 */
public abstract class RecordControlUseTime<T> extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RecordControlUseTime.class);
	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("ThreadLocal StartTime");
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// 线程绑定变量（该数据只有当前请求的线程可见）
		startTimeThreadLocal.set(DateUtil.nowMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex)  throws Exception {
		try {

			String str = "";
			if (null != ex) {
				str = ExceptionUtil.getExceptionAllinformation_01(ex);
			}
			double useTime = DateUtil.getDateDiffSecond(startTimeThreadLocal.get(), DateUtil.nowMillis());
			BaseUseTimeEntity baseUseTime = new BaseUseTimeEntity();
			baseUseTime.setIp(HttpUtil.getIPAddress(request));
			baseUseTime.setMethod(request.getRequestURI());
			baseUseTime.setUseTime(useTime);
			HandlerMethod method = (HandlerMethod) handler;
			baseUseTime.setPath(method.getMethod().getDeclaringClass() + "." + method.getMethod().getName());
			baseUseTime.toMaxMemoryDetail();
			if (str != "") {
				// 得到线程绑定的局部变量（开始时间）
				baseUseTime.setException(str);
				toDealWith(baseUseTime);
			}else {
				toDealWith(baseUseTime);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 根据实际情况进行处理
	 */
	public abstract void toDealWith(BaseUseTimeEntity baseUseTime);
}
