package com.spring.base.common.redis;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
public class RedisLock {
	private static final Logger log = (Logger) LoggerFactory.getLogger(RedisLock.class);
	 /**
     * 锁过期时间
     */
    private static final Long timeout=60*1000L;
    private static final String Lock="RedisLock";
	/**
	 * setnx方式 后来发现有setnx的原子操作命令，锁存在不能设置值，返回0；锁不存在，则设置锁，返回1； 加锁：jedis.setnx(lock, 1)
	 */
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	 public void myLock(String key, Method method) throws Exception{
	        lock(Lock+ key,  method);
	    }
	public void lock(String key, Method method)  throws Exception{
	    long startTime=System.currentTimeMillis();
        String value = startTime+"";
        boolean flag=this.tryLock(key, value);
        log.info("【redis分布式锁 （"+flag+"）】, {key:"+key+",value:"+value+"}");
        if (flag) {
            method.runMethod();
            this.unlock(key);
        } else {
            log.info("【redis分布式锁 （"+flag+"）获取失败尝试重新获取锁】, {key:"+key+",value:"+value+"}");
            this.lock(key, method);
        }
        long endTime=System.currentTimeMillis();
        log.info("【redis分布式锁 ，运行 耗时 ："+(endTime-startTime)+" 毫秒】");
	}

	private boolean tryLock(String key, String value) {
		try {
			Boolean lock = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.SECONDS);
			if (lock) {
				log.info("【redis分布式锁 ，加锁陈成功A】, {key:"+key+",value:"+value+"}");
				return true;
			}
			 String currentValue = redisTemplate.opsForValue().get(key);
	            Long now=System.currentTimeMillis();
	            // 如果锁过期则删除锁并尝试重新加载锁
	            if (null != currentValue && now- Long.parseLong(currentValue)>timeout) {
	                redisTemplate.opsForValue().getOperations().delete(key);
	                log.info("【redis分布式锁 ，解锁陈成功B】, {key:"+key+"}");
	                Boolean lockC = redisTemplate.opsForValue().setIfAbsent(key, value);
	                if (lockC) {
	                    log.info("【redis分布式锁 ，加锁陈成功B】, {key:"+key+",value:"+value+"}");
	                    return true;
	                }
	            }
		}catch (Exception e) {
			log.error("【redis分布式锁  tryLock】加锁异常, {非分布式执行，请尽快查找问题}", e);
			return true;
		}

		return false;
	}

	private void unlock(String key) {
		try {			
			redisTemplate.opsForValue().getOperations().delete(key);
			log.info("【redis分布式锁 ，解锁陈成功】, {key:"+key+"}");
		} catch (Exception e) {
			log.error("【redis分布式锁   unlock】解锁异常, {key:"+key+"}", e);
		}
	}

}
