package com.spring.base.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.base.common.json.JsonUtil;
import com.spring.base.filter.entity.BaseUseTimeEntity;


  //@Component 
  public class ExampleRecordControlUseTime extends
  RestControllerAdviceUtil{
  
  private static final Logger logger =
  LoggerFactory.getLogger(ExampleRecordControlUseTime.class);
  
  @Override public void toDealWith(BaseUseTimeEntity t) {
  logger.info(JsonUtil.toJsonString(t));
  
  }
  
  }