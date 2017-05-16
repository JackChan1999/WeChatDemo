package com.jackchan.wechat.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jackchan.wechat.R;
import com.jackchan.wechat.base.Global;
import com.jackchan.wechat.bean.WeChat;
import com.jackchan.wechat.ui.adapter.WeiboAdapter;
/**
 * ============================================================
 * Copyright：JackChan和他的朋友们有限公司版权所有 (c) 2017
 * Author：   JackChan
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChan1999
 * GitBook：  https://www.gitbook.com/@alleniverson
 * CSDN博客： http://blog.csdn.net/axi295309066
 * 个人博客： https://jackchan1999.github.io/
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：WeChatDemo
 * Package_Name：com.jackchan.wechat
 * Version：1.0
 * time：2017/5/16 12:39
 * des ：微信朋友圈，QQ空间，微博等列表展示的功能实现
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/16 12:39
 * updateDes：${TODO}
 * ============================================================
 */
public class MainActivity extends AppCompatActivity {

    private LinearLayout llTitleBar;
    private TextView tvTitle;
    private RecyclerView recyclerView;
    private TextView tvLike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llTitleBar = (LinearLayout) findViewById(R.id.ll_title_bar);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        tvLike = (TextView) findViewById(R.id.tv_like);

        initRecyclerView();
    }

    private void initRecyclerView() {
        // 加载微博数据
        String json = Global.readAssets("weibo_list.json");
        Gson gson = new Gson();
        WeChat weibo = gson.fromJson(json, WeChat.class);
        Global.showToast("微博条数：" + weibo.getWeibo().size());

        // 显示微博列表
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new WeiboAdapter(this, weibo.getWeibo()));
    }
}
