package com.example.wangjing.joketask.task;
/**
 * @author wangjing
 * @since 2016/5/25 11:51
 * @version 1.0
 * <p><strong>Features draft description.异步任务返回的结果，通用数据对象《/br》
 *          包含： 1、1action 代表当前的结果由哪一个异步任务来返回的；</br>
 *          2、data 代表Object对象，就是异步任务的返回对象</strong></p>
 */
public class TaskResult {
    /**
     * 异步任务的标识,
     */
    public  int action;

    public Object data;
}
