package com.spring.base.common.redis;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
public class RedisLock {
	private static final Logger log = (Logger) LoggerFactory.getLogger(RedisLock.class);	 
    private  Long timeout=60L;
    private  String redisLock = "RedisLock";	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	 private void lock(String key, Method method) {
	    long startTime=System.currentTimeMillis();
	    try {    	
	        this.tryLock(redisLock+key,method);
	        long endTime=System.currentTimeMillis();
	        log.info("【redis分布式锁 ，运行 耗时 ："+(endTime-startTime)+" 毫秒】");
	    }catch (Exception e){
            log.error("【redis分布式锁 锁内运行程序异常】",e);
        }
	}
	private void tryLock(String key, Method method) {
		/**
    	 * 确保value是唯一的
    	 */
		String value=redisTemplate.opsForValue().increment(redisLock+"add"+key)+"";
		try {
			Boolean lock = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.SECONDS);
			if (lock) {
				log.info("【redis分布式锁 ，加锁陈成功A】, {key:"+key+",value:"+value+"}");
				method.runMethod();
	            this.unlock(key,value);
			}else {
				TimeUnit.MILLISECONDS.sleep(1);
				tryLock( key, method);
			}
		}catch (Exception e) {
			log.error("【redis分布式锁  tryLock】加锁异常, {非分布式执行，请尽快查找问题}", e);
		}
	}
	private void unlock(String key, String value) {
		try {	
			String RedisValue=redisTemplate.opsForValue().get(key);
			if(RedisValue.equals(value)) {
				redisTemplate.opsForValue().getOperations().delete(key);
			}			
			log.info("【redis分布式锁 ，解锁陈成功】, {key:"+key+"}");
		} catch (Exception e) {
			log.error("【redis分布式锁   unlock】解锁异常, {key:"+key+"}", e);
		}
	}

}
