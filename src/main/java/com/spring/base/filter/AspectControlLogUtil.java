package com.spring.base.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponseWrapper;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import com.alibaba.fastjson.JSON;
import com.spring.base.common.date.DateUtil;
import com.spring.base.filter.entity.BaseUseTimeEntity;


public  abstract class AspectControlLogUtil {		
	  @Around("execution(* com.spring.base.control.**.find*(..))") 
	  public void
	  aroundControl(ProceedingJoinPoint pjp) throws Throwable { around( pjp); }
	 
		private void around(ProceedingJoinPoint pjp) throws Throwable {
			//通过uuid关联请求参数和返回参数 String
			long start=DateUtil.nowMillis();
			try { 
				MethodSignature ht=(MethodSignature) pjp.getSignature();
				BaseUseTimeEntity baseUse=new BaseUseTimeEntity();
				baseUse.setMethod(pjp.getSignature().getName());
				baseUse.setPath(ht.getMethod()+"");					
				long end=DateUtil.nowMillis();
				baseUse.setUseTime(DateUtil.getDateDiffSecond(start, end));
				toDealWith( baseUse);
			} catch (Exception e) { 
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		/**
		 * 根据实际情况进行处理
		 */
		public abstract void toDealWith(BaseUseTimeEntity baseUseTime);
}
