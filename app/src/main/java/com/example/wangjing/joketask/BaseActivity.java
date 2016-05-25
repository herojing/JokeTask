package com.example.wangjing.joketask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author wangjing
 * @since 2016/5/25 9:58
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        initView();
        loaderData();
    }

    /**
     * 做初始化方面的工作,比如接收上一个界面的Intent
     */
    public abstract void initVariables();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 加载数据
     */
    public abstract void loaderData();
}
