
package com.example.wangjing.joketask.task.joketask;

import com.example.wangjing.joketask.Constants;
import com.example.wangjing.joketask.client.JokeClient;
import com.example.wangjing.joketask.entities.Joke;
import com.example.wangjing.joketask.task.BaseTask;
import com.example.wangjing.joketask.task.TaskCallBack;
import com.example.wangjing.joketask.task.TaskResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

/**
 * @author wangjing
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 * @since 2016/5/25 10:20
 */
public class JokeTask extends BaseTask {

    public JokeTask(TaskCallBack mTaskCallBack) {
        super(mTaskCallBack);
    }

    @Override
    protected TaskResult doInBackground(String... params) {
        TaskResult result = null;
        if (params != null) {
            result = new TaskResult();
            result.action = Constants.TASK_ACTION_GET_JOKE_CONTENT;
            JSONObject jokeContent = JokeClient.getJokeContent(params[0], params[1]);
            result.data = parseJson(jokeContent);
        }
        return result;
    }

    private Joke parseJson(JSONObject pObject) {
        Joke ret = null;
        if (pObject != null) {
            Gson gson = new Gson();
            ret = gson.fromJson(pObject.toString(), new TypeToken<Joke>() {}.getType());
        }
        return ret;
    }
}
