package com.example.wangjing.joketask;

import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.wangjing.joketask.adapter.JokeAdapter;
import com.example.wangjing.joketask.entities.Joke;
import com.example.wangjing.joketask.entities.JokeInfo;
import com.example.wangjing.joketask.task.TaskCallBack;
import com.example.wangjing.joketask.task.TaskResult;
import com.example.wangjing.joketask.task.joketask.JokeTask;

import java.util.ArrayList;
/**
 * @author wangjing
 * @since 2016/5/25 9:59
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class MainActivity extends BaseActivity implements TaskCallBack {

    // 不做分页加载的操作，所以这两个参数写死
    public static final String PAGE_NUM = "1";

    public static final String PAGE_SIZE = "20";

    private ListView mListView;

    private ArrayList<JokeInfo> mJokeInfoArrayList = null;

    @Override
    public void initVariables() {
        mJokeInfoArrayList = new ArrayList<>();
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(R.string.app_name);
        }
        mListView = (ListView) findViewById(R.id.main_page_joke_lv);
    }

    @Override
    public void loaderData() {

        JokeTask joketask = new JokeTask(this);
        joketask.execute(PAGE_NUM, PAGE_SIZE);
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int action = result.action;
            switch (action) {
                case Constants.TASK_ACTION_GET_JOKE_CONTENT:
                    if (result.data instanceof Joke) {
                        Joke joke= (Joke) result.data;
                        mJokeInfoArrayList=joke.getResult().getJokeInfoArrayList();
                        JokeAdapter jokeAdapter = new JokeAdapter(this, mJokeInfoArrayList);
                        mListView.setAdapter(jokeAdapter);
                    }
                    break;
            }
        }
    }
}
