package com.example.wangjing.joketask.task;

/**
 * ============================================================
 * author：     王景
 * <p/>
 * time：       2015/9/22  15:59.
 * <p/>
 * email:     wjontheway@163.com
 * <p/>
 * description： 异步任务返回的结果，通用数据对象《/br》
 *          包含： 1、1action 代表当前的结果由哪一个异步任务来返回的；</br>
 *          2、data 代表Object对象，就是异步任务的返回对象
 * <p/>
 * ============================================================
 */
public class TaskResult {
    /**
     * 异步任务的标识,
     */
    public  int action;

    public Object data;
}
