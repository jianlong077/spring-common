package com.spring.base.filter;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.base.common.date.DateUtil;
import com.spring.base.common.json.JsonUtil;
import com.spring.base.filter.entity.BaseUseTimeEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
/**
 * 
 * @author LOVE_HAIYAN_521
 *  匹配所有的public修饰符的方法: execution(public * *(..))
 *  匹配所有”set”开头的方法: execution(* set*(..)) 
 *  匹配AccountService 接口的所有方法: execution(* com.xyz.service.AccountService.*(..)) 
 *  匹配service包中的所有方法: execution(* com.xyz.service..(..)) 
 *  匹配service包及其子包中的所有方法: execution(* com.xyz.service...(..)) 
 *  匹配joke(String,int)方法，且joke()方法的第一个入参是String，第二个入参是int。如果方法中的入参类型是Java.lang包下的类，
 *  		可以直接使用类名，否则必须使用全限定类名，如joke(java.util.List,int)；
 *         execution(* joke(String,int)) 
 * 匹配目标类中的joke()方法，该方法第一个入参为String，第二个入参可以是任意类型，如joke(Strings1,String
 *         s2)和joke(String s1,double d2)都匹配，但joke(String s1,doubled2,String
 *         s3)则不匹配；
 *          execution(* joke(String,*)) 
 * 匹配目标类中的joke()方法，该方法第 一个入参为String，后面可以有任意个入参且入参类型不限，如joke(Strings1)、joke(String s1,String
 *         s2)和joke(String s1,double d2,Strings3)都匹配。
 *          execution(* joke(String,..)) 
 *匹配目标类中的joke()方法，方法拥有一个入参，且入参是Object类型或该类的子类。它匹配joke(Strings1)和joke(Client
 *         c)。如果我们定义的切点是execution(*joke(Object))，则只匹配joke(Object
 *         object)而不匹配joke(String cc)或joke(Client c)。 
 *         execution(* joke(Object+))
 */
public class LogUseTimeAspect {
	private Long USE_TIME = 0L;
	private static final Logger logger = LoggerFactory.getLogger("");
	private final String POINT_CUT_CONTROL = "execution(public * com.spring.base.control.*.*(..))";
	private final String POINT_CUT_SERVICE = "execution(public * com.spring.base.service.impl.*.*(..))";
	private final String POINT_CUT_DAO = "execution(public * com.spring.base.dao.impl.*.*(..))";

	@Around(value = POINT_CUT_CONTROL)
	public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Long startTime = System.currentTimeMillis();
		BaseUseTimeEntity baseUseTimeEntity = new BaseUseTimeEntity();
		Object obj = null;
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			obj = proceedingJoinPoint.proceed(); // 可以加参数
			MethodSignature ht = (MethodSignature) proceedingJoinPoint.getSignature();
			baseUseTimeEntity.setMethod(proceedingJoinPoint.getSignature().getName());
			baseUseTimeEntity.setPath(ht.getMethod() + "");
			baseUseTimeEntity.setIp(request.getRemoteAddr());
			baseUseTimeEntity.toMaxMemoryDetail();
		} catch (Throwable throwable) {
			logger.error("异常", throwable);
		}
		Long endTime = System.currentTimeMillis();
		long useTime = endTime - startTime;
		if (useTime >= USE_TIME) {
			baseUseTimeEntity.setUseTime(DateUtil.getDateDiffSecond(startTime, endTime));
			logger.info(JsonUtil.toJsonString(baseUseTimeEntity));
		}
		return obj;
	}

	@Around(value = POINT_CUT_SERVICE)
	public Object doAroundService(ProceedingJoinPoint proceedingJoinPoint) {
		Long startTime = System.currentTimeMillis();
		BaseUseTimeEntity baseUseTimeEntity = new BaseUseTimeEntity();
		Object obj = null;
		try {
			obj = proceedingJoinPoint.proceed(); // 可以加参数
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			MethodSignature ht = (MethodSignature) proceedingJoinPoint.getSignature();
			baseUseTimeEntity.setMethod(proceedingJoinPoint.getSignature().getName());
			baseUseTimeEntity.setPath(ht.getMethod() + "");
			baseUseTimeEntity.setIp(request.getRemoteAddr());
			baseUseTimeEntity.toMaxMemoryDetail();
		} catch (Throwable throwable) {
			logger.error("异常", throwable);
		}
		Long endTime = System.currentTimeMillis();
		long useTime = endTime - startTime;
		if (useTime >= USE_TIME) {
			baseUseTimeEntity.setUseTime(DateUtil.getDateDiffSecond(startTime, endTime));
			logger.info(JsonUtil.toJsonString(baseUseTimeEntity));
		}
		return obj;
	}

	@Around(value = POINT_CUT_DAO)
	public Object doAroundDao(ProceedingJoinPoint proceedingJoinPoint) {
		Long startTime = System.currentTimeMillis();
		BaseUseTimeEntity baseUseTimeEntity = new BaseUseTimeEntity();
		Object obj = null;
		try {
			obj = proceedingJoinPoint.proceed(); // 可以加参数
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			MethodSignature ht = (MethodSignature) proceedingJoinPoint.getSignature();
			baseUseTimeEntity.setMethod(proceedingJoinPoint.getSignature().getName());
			baseUseTimeEntity.setPath(ht.getMethod() + "");
			baseUseTimeEntity.setIp(request.getRemoteAddr());
			baseUseTimeEntity.toMaxMemoryDetail();
		} catch (Throwable throwable) {
			logger.error("异常", throwable);
		}
		Long endTime = System.currentTimeMillis();
		long useTime = endTime - startTime;
		if (useTime >= USE_TIME) {
			baseUseTimeEntity.setUseTime(DateUtil.getDateDiffSecond(startTime, endTime));
			logger.info(JsonUtil.toJsonString(baseUseTimeEntity));

		}
		return obj;
	}
}
