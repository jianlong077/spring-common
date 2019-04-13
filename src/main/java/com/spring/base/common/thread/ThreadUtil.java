package com.spring.base.common.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import com.spring.base.common.thread.myclass.MyRunnable;
import com.spring.base.common.thread.myclass.MyfutureTask;
import com.spring.base.common.thread.myclass.ToRunMethod;
import com.spring.base.common.thread.myclass.ToRunTaskMethod;

public class ThreadUtil<T> extends MyThreadPool {
	private ConcurrentHashMap<String, FutureTask<T>> futureTaskMap=new ConcurrentHashMap<>();

	public ThreadUtil() {

	}

	/**
	 * @方法名:toRun
	 * @备注 : 可用于执行不需要拥有返回值的方法
	 * @参数 taskName :任务名称
	 * @参数 toRunMethod : 接口需要实现里边的方法
	 * @异常 Exception : 工具类不做异常处理直接抛出
	 */
	public void toRun(String taskName, ToRunMethod toRunMethod) throws Exception {
		MyRunnable myTaskRunnable = new MyRunnable(taskName, toRunMethod);
		pool.submit(myTaskRunnable);
	}

	/**
	 * @方法名:toRunTask
	 * @备注 : 可用于执行需要拥有返回值的方法,与 getObject 配合使用,每次执行都需要从新new [ MyThreadUtil<String>
	 *     a=new MyThreadUtil<>() String object=a.getObject()) ]
	 * @参数 taskName :任务名称
	 * @参数 toRunMethod : 接口需要实现里边的方法
	 * @异常 Exception : 工具类不做异常处理直接抛出
	 */
	public void toRunTask(String taskName, ToRunTaskMethod<T> toRunMethod) throws Exception {
		MyfutureTask<T> futureTask = new MyfutureTask<T>(new Callable<T>() {
			@Override
			public T call() throws Exception {
				return toRunMethod.run();
			}
		}, taskName);
		this.futureTaskMap.put(taskName, futureTask);
		pool.submit(futureTask);
	}

	/**
	 * @方法名:toGetTask
	 * @备注 : 可用于执行需要拥有返回值的方法,与 myfutureTask 配合使用,先执行toRunTask ，再执行toGetTask
	 * @参数 taskName :任务名称
	 * @参数 toRunTask : 接口需要实现里边的方法
	 * @异常 Exception : 工具类不做异常处理直接抛出
	 */
	public T toRunTask(String taskName){
		T t = null;
		try {
			t = this.futureTaskMap.get(taskName).get(25000, TimeUnit.MILLISECONDS);
			if (t != null) {
				this.futureTaskMap.get(taskName).cancel(true);
				this.futureTaskMap.remove(taskName);
			}
		} catch (Exception e) {
			this.futureTaskMap.get(taskName).cancel(true);
			this.futureTaskMap.remove(taskName);
		}
		return t;
	}
}
