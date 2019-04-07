package com.spring.common.thread.myclass;

/**
 * 服务于没有返回函数的Runnable的改写
 * @param <T>
 */
public class MyTaskRunnable <T> implements Runnable{
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 运行要执行任务的方法
     */
    private ToRunTaskMethod<T> toRunMethod;
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public void run() {
        toRunMethod.run();
    }

    public MyTaskRunnable( String taskName, ToRunTaskMethod<T> toRunMethod) {
        this.taskName = taskName;
        this.toRunMethod = toRunMethod;
    }
}
