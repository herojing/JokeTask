package com.example.wangjing.joketask.task;
/**
 * @author wangjing
 * @since 2016/5/25 11:26
 * @version 1.0
 * <p><strong>Features draft description.当异步任务执行完成返回的结果交给回调接口<br/>
 * 利用TaskResult来抽象结果的实际类型</strong></p>
 */
public interface TaskCallBack {
    void onTaskFinished(TaskResult result);
}
