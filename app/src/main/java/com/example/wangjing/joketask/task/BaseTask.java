package com.example.wangjing.joketask.task;

import android.os.AsyncTask;

/**
 * ============================================================
 * author：     王景
 * <p/>
 * time：       2015/9/22  16:58.
 * <p/>
 * email:     wjontheway@163.com
 * <p/>
 * description：
 * <p/>
 * ============================================================
 */
public abstract class BaseTask extends AsyncTask<String ,Integer,TaskResult> {

    private final TaskCallBack  mTaskCallBack;

    public BaseTask(TaskCallBack mTaskCallBack) {
        this.mTaskCallBack = mTaskCallBack;
    }
    @Override
    protected TaskResult doInBackground(String... params) {
        return null;
    }
    @Override
    protected void onPostExecute(TaskResult result) {
        if (mTaskCallBack != null) {
            mTaskCallBack.onTaskFinished(result);
        }
    }
}
