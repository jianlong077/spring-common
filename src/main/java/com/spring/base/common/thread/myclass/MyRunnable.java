package com.spring.base.common.thread.myclass;

/**
 * 服务于没有返回函数的Runnable的改写
 * @param <T>
 */
public class MyRunnable implements Runnable{
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 运行要执行任务的方法
     */
    private ToRunMethod toRunMethod;
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

    public MyRunnable( String taskName, ToRunMethod toRunMethod) {
        this.taskName = taskName;
        this.toRunMethod = toRunMethod;
    }
}
