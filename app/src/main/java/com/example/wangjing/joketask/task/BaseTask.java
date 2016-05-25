package com.example.wangjing.joketask.task;

import android.os.AsyncTask;

/**
 * @author wangjing
 * @since 2016/5/25 10:10
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
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
