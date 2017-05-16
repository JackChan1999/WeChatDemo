package com.jackchan.wechat.ui.holder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackchan.wechat.R;
import com.jackchan.wechat.base.Global;
import com.jackchan.wechat.bean.WeChat;
import com.jackchan.wechat.ui.activity.MainActivity;
import com.jackchan.wechat.ui.adapter.BaseAdapterRV;
import com.jackchan.wechat.ui.adapter.ImageAdapter;
import com.jackchan.wechat.util.EmojiUtil;
import com.jackchan.wechat.util.LinkifyUtil;
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

public class WeiboHolder extends BaseHolderRV<WeChat.WeiboBean> {

    private ImageView ivAvatar;
    private TextView tvUser;
    private TextView tvUserIntroduction;
    private TextView tvDate;
    private TextView tvContent;
    private RecyclerView rvWeiboImages;
    private TextView tvForward;
    private TextView tvComment;
    private CheckBox cbLike;
    private TextView tvLike;
    private ImageAdapter imageAdapter;
    private GridLayoutManager layoutManager;

    public WeiboHolder(Context context, ViewGroup parent,
                       BaseAdapterRV<WeChat.WeiboBean> adapter,
                       int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_weibo);
    }

    // 查找item布局中的子控件
    @Override
    public void onFindViews(View itemView) {
        ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tvUser = (TextView) itemView.findViewById(R.id.tv_user);
        tvUserIntroduction = (TextView) itemView.findViewById(R.id.tv_user_introduction);
        tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        tvForward = (TextView) itemView.findViewById(R.id.tv_forward);
        tvComment = (TextView) itemView.findViewById(R.id.tv_comment);
        cbLike = (CheckBox) itemView.findViewById(R.id.cb_like);
        tvLike = (TextView) itemView.findViewById(R.id.tv_like);

        // 展示九宫格图片
        rvWeiboImages = (RecyclerView) itemView.findViewById(R.id.rv_weibo_images);
        layoutManager = new GridLayoutManager(context, 3);
        rvWeiboImages.setLayoutManager(layoutManager);
        imageAdapter = new ImageAdapter(context, null);
        rvWeiboImages.setAdapter(imageAdapter);

        cbLike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 获取当前点击控件相对于窗口的所在位置
                    int[] locations = new int[2];
                    tvLike.getLocationInWindow(locations);
                    ((MainActivity) context).animateUp(locations);
                }
            }
        });
    }

    // 刷新item布局中子控件的显示
    @Override
    protected void onRefreshView(WeChat.WeiboBean bean, int position) {
        // 显示用户名
        tvUser.setText(bean.getUsername());

        // 显示用户介绍
        if (TextUtils.isEmpty(bean.getUser_introduction())) {
            tvUserIntroduction.setVisibility(View.GONE);
        } else {
            tvUserIntroduction.setVisibility(View.VISIBLE);
            tvUserIntroduction.setText(bean.getUser_introduction());
        }
        // 显示头像
        int imageResId = Global.getResId(context, bean.getAvatar());
        ivAvatar.setBackgroundResource(imageResId);

        // 微博内容
        // tvContent.setText(bean.getContent());
        EmojiUtil.setText(tvContent, bean.getContent());
        LinkifyUtil.addCustomLink(tvContent);
        LinkifyUtil.addCustomLink2(tvContent);

        // 发表时间
        tvDate.setText(Global.formatDate(bean.getDate()));

        // 显示微博图片
        int imageCount = bean.getImageUrls() == null
                ? 0 : bean.getImageUrls().size();
        if (imageCount == 0) {      // 没有微博图片
            rvWeiboImages.setVisibility(View.GONE);
        } else {    // 有微博图片
            rvWeiboImages.setVisibility(View.VISIBLE);
            imageAdapter.setDatas(bean.getImageUrls()); // 刷新图片显示

            // 动态的指定图片宫格的宽高和RecyclerView的宽度
            // 1张图片 -> 1列
            // 4张图片 -> 2列
            // 其它    -> 3列
            ViewGroup.LayoutParams param = rvWeiboImages.getLayoutParams();
            if (imageCount == 1) {
                layoutManager.setSpanCount(1);
                param.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else if (imageCount == 4) {
                layoutManager.setSpanCount(2);
                // 两个图片宫格的宽度
                param.width = Global.getGridWidth() * 2;
            } else {        // 3列
                layoutManager.setSpanCount(3);
                param.width = ViewGroup.LayoutParams.MATCH_PARENT;
            }
        }
    }
}
