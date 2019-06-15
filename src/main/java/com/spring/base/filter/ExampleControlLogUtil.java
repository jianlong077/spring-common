package com.spring.base.filter;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.base.common.json.JsonUtil;
import com.spring.base.filter.entity.BaseUseTimeEntity;


@Aspect
@Component("exampleControlLogUtil")
  public class ExampleControlLogUtil extends
  AspectControlLogUtil{
  
  private static final Logger logger =
  LoggerFactory.getLogger(ExampleControlLogUtil.class);
  
  @Override public void toDealWith(BaseUseTimeEntity t) {
  logger.info(JsonUtil.toJsonString(t));
  
  }
  
  }