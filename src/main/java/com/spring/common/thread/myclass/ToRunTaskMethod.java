package com.spring.common.thread.myclass;
/**
 * 自定义改写run方法
 */
public interface ToRunTaskMethod<T>{
	
    T run();
}
