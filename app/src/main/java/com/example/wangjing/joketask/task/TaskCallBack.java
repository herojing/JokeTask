package com.example.wangjing.joketask.task;

/**
 * ============================================================
 * author：     王景
 * <p/>
 * time：       2015/9/22  16:06.
 * <p/>
 * email:     wjontheway@163.com
 * <p/>
 * description：  当异步任务执行完成返回的结果交给回调接口<br/>
 * 利用TaskResult来抽象结果的实际类型
 * <p/>
 * ============================================================
 */
public interface TaskCallBack {
    void onTaskFinished(TaskResult result);
}
