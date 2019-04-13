package com.spring.base.common.thread.myclass;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 服务于带有返回函数的FutureTask的改写
 * @param <T>
 */
public class MyfutureTask<T> extends FutureTask<T> {
    /**
     * 任务名称
     */
    private String taskName;
    public MyfutureTask(Callable<T> callable, String taskName) {
        super(callable);
        this.taskName=taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
