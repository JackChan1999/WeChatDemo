package com.jackchan.wechat.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jackchan.wechat.bean.WeChat;
import com.jackchan.wechat.ui.holder.BaseHolderRV;
import com.jackchan.wechat.ui.holder.WeiboHolder;

import java.util.List;
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
 * des ：朋友圈列表的适配器
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/16 12:39
 * updateDes：${TODO}
 * ============================================================
 */

public class WeiboAdapter extends BaseAdapterRV<WeChat.WeiboBean> {

    public WeiboAdapter(Context context, List<WeChat.WeiboBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<WeChat.WeiboBean> createViewHolder(
            Context context, ViewGroup parent, int viewType) {
        return new WeiboHolder(context, parent, this, viewType);
    }
}
